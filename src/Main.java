import java.util.ArrayList;

public class Main {
    static class Edge{
        int source;int destination;

        public Edge(int s,int d){
            this.source=s;
            this.destination=d;
        }
    }

     static void createGraph(ArrayList<Edge>graph[]){
        for (int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
     }

     public static boolean isCycle(ArrayList<Edge>[]graph){
        boolean visited[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

         for (int i=0;i<graph.length;i++){
             if (!visited[i]){
                 if(isCycleUtil( graph,i,visited,stack)){
                     return true;
                 }
             }

         }
         return false;
     }

     public static boolean isCycleUtil(ArrayList<Edge>[]graph,int currentnode,boolean visited[],boolean stack[]){
         visited[currentnode]=true;
         stack[currentnode]=true;

         for (int i=0;i<graph[currentnode].size();i++){
             Edge e=graph[currentnode].get(i);

             if (stack[e.destination]){//cycle exists
                 return true;
             }
             if (!visited[e.destination] && isCycleUtil(graph,e.destination,visited,stack)){
                 return true;


             }
         }
         stack[currentnode]=false;
         return false;
     }
    public static void main(String[] args) {
        int vertex=4;
        ArrayList<Edge>graph[]=new ArrayList[vertex];
        createGraph(graph);

        System.out.println(isCycle(graph));

    }
}