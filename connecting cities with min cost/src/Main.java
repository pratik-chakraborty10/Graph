import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;

        public Edge(int d,int c){
            this.dest=d;
            this.cost=c;
        }
        @Override
        public int compareTo(Edge e2){
           return this.cost-e2.cost;
        }
    }

    public static int connectingCities(int cities[][]){
        PriorityQueue<Edge>pq=new PriorityQueue<>();
        boolean visited[]=new boolean[cities.length];
        pq.add(new Edge(0,0));
        int finalcost=0;

        while (!pq.isEmpty()){
            Edge current=pq.remove();
            if (!visited[current.dest]){
                visited[current.dest]=true;
                finalcost+= current.cost;

                for (int i=0;i<cities[current.dest].length;i++){
                   if (cities[current.dest][i]!=0){
                       pq.add(new Edge(i,cities[current.dest][i]));
                   }
                }
            }
        }
        return finalcost;
    }
    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},
                {1,0,5,0,7},
                {2,5,0,6,0},
                {3,0,6,0,0},
                {4,7,0,0,0}};

        System.out.println(connectingCities(cities));


    }
}