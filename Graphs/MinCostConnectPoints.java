import java.util.*;
class Pair{
    int node;
    int cost;

    public Pair(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
public class MinCostConnectPoints {
    public static int minCostConnectPoints(int[][] points){
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Pair(0, 0));

        int minCost = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.cost;

            if(visited[node]){
                continue;
            }

            visited[node] = true;
            minCost += cost;

            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    int dist =  Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                    pq.offer(new Pair(i, dist));
                }
            }
        }
        return minCost;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] points = new int[n][2];
        for(int i = 0; i < n; i++){
            points[i][0] = scn.nextInt();
            points[i][1] = scn.nextInt();
        }
        int answer = minCostConnectPoints(points);
        System.out.println(answer);
    }
}
