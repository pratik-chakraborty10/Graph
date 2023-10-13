import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;

        }
    }
    public static void createGraph(int flights[][],ArrayList<Edge>[]graph){
        for (int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();

        }

        for (int i=0;i< flights.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];


            Edge e=new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }

    static class Info{
        int node;
        int cost;
        int stops;

        public Info(int n,int c,int s){
            this.node=n;
            this.cost=c;
            this.stops=s;
        }
    }

    public static int cheapestFlight(int n,int flights[][],int src,int dest,int k){
        ArrayList<Edge>[]graph=new ArrayList[n];
        createGraph(flights,graph);


        int distance[]=new int[n];
        for (int i=0;i<n;i++){
            if (i!=src){
                distance[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info>q=new LinkedList<>();
        q.add(new Info(src,0,0));

        while (!q.isEmpty()){
           Info current=q.remove();
           if (current.stops>k){
               break;
           }
           for (int i=0;i<graph[current.node].size();i++){
               Edge e=graph[current.node].get(i);
               int u=e.src;
               int v=e.dest;
               int wt=e.wt;

               if (current.cost+wt<distance[v] && current.stops<=k){
                   distance[v]=current.cost+wt;
                   q.add(new Info(n,distance[v],current.stops+1 ));
               }


           }
        }

        //distance of destination
        if (distance[dest]==Integer.MAX_VALUE){
            return -1;
        }else {
            return distance[dest] ;
        }

    }


    public static void main(String[] args) {
        int n=4;
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int source=0,destination=3,k=1;
        cheapestFlight(n,flights,source,destination,k);







    }
}