package Graphs;
import java.util.*;
public class AllPaths {
    public static void allPaths(int node, int[][] graph, List<Integer> path, List<List<Integer>> result){
        path.add(node);
        if(node == graph.length-1){
            result.add(new ArrayList<>(path));
        }else{
            for(int neighbour: graph[node]){
                allPaths(neighbour, graph, path, result);
            }
        }
        path.remove(path.size()-1);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] graph = new int[n][];

        for(int i = 0; i < n; i++){
            int size = scn.nextInt();
            
            for(int j = 0; j < size; j++){
                graph[i][j] = scn.nextInt();
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        allPaths(0, graph, new ArrayList<>(), result);
        for(List<Integer> path: result){
            System.out.println(path);
        }
    }
}
