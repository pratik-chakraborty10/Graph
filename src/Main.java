import java.util.ArrayList;

public class Main {
    static class Edge{
        int source;
        int destination;

        public Edge(int s,int d){
            this.source=s;
            this.destination=d;
        }
    }

    static void createGraph(ArrayList<Edge>graph[]){
        for (int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static boolean detectCycle(ArrayList<Edge>[]graph){
        boolean visited[]=new boolean[graph.length];
        for (int i=0;i< graph.length;i++){
            if(!visited[i]){
                if(detectCycleUtil(graph,visited,i,-1) ){
                    return true;
                    //cycle exists in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[]graph,boolean visited[],int currentNode,int parentNode){
        visited[currentNode]=true;
        for (int i=0;i<graph[currentNode].size();i++){
            Edge e=graph[currentNode].get(i);
            //case->3
            if (!visited[e.destination] ){
                if (detectCycleUtil(graph,visited,e.destination,currentNode)){
                    return true;

                }


            } else if (visited[e.destination] && e.destination!=parentNode) {//case->1
                return true;
                
            }
            //case 2->do nothing->continue
        }
        return false;

    }
    public static void main(String[] args) {

        int vertex=5;
        ArrayList<Edge>graph[]=new ArrayList[vertex];
        createGraph(graph);

        System.out.println(detectCycle(graph));

    }
}