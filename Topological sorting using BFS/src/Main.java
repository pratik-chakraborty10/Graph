import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Edge{
        int source;
        int destination;

        public Edge(int s, int d){
            this.source=s;
            this.destination=d;
        }
    }

    static void createGraph(ArrayList<Edge>[]graph){
        for (int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void calIndegree(ArrayList<Edge>[]graph,int indegree[]){
        for (int i=0;i< graph.length;i++ ){
            int vertex=i;
           for (int j=0;j<graph[vertex].size();j++){
               Edge e=graph[vertex].get(j);
               indegree[e.destination]++;
           }
        }
    }
    public static void TopologicalSort(ArrayList<Edge>[]graph){
        int indegree[]=new int[graph.length];
        calIndegree(graph,indegree);
        Queue<Integer>queue=new LinkedList<>();

        for (int i=0;i< indegree.length;i++){
            if (indegree[i]==0){
                queue.add(i);
            }
        }

        //bfs
        while (!queue.isEmpty()){
            int current=queue.remove();
            System.out.print(current+" ");//topological sort print

            for (int i=0;i<graph[current].size();i++){
                Edge e=graph[current].get(i);
                indegree[e.destination]--;
                if (indegree[e.destination]==0){
                    queue.add(e.destination);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int vertex=6;
        ArrayList<Edge>graph[]=new ArrayList[vertex];
        createGraph(graph);
        TopologicalSort(graph);


    }
}