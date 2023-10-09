import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static class Edge{
        int source;
        int destination;

        public Edge(int s,int d){
            this.source=s;
            this.destination=d;
        }
    }

    static void  createGraph(ArrayList<Edge>graph[]){
        for (int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,0));
    }

    public static void topologicalSort(ArrayList<Edge>[] graph){
        boolean visited[]=new boolean[graph.length];
        Stack<Integer>s=new Stack<>();

        for (int i=0;i< graph.length;i++){
            if (!visited[i]){
                topologicalSortUtil(graph,i,visited,s);
            }
        }
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[]graph,int currentNode,boolean visited[],Stack<Integer>s){
        visited[currentNode]=true;
        for (int i=0;i<graph[currentNode].size();i++){
            Edge e=graph[currentNode].get(i);
            if (!visited[e.destination]){
                topologicalSortUtil(graph,e.destination,visited,s);
            }
        }
        s.push(currentNode);
    }
    public static void main(String[] args) {
        int vertex=6;
        ArrayList<Edge>graph[]=new ArrayList[vertex];
        createGraph(graph);
        topologicalSort(graph);

    }
}