import java.util.*;
class Pair{
    int rows;
    int cols;

    public Pair(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }
}
public class RottenOranges{
    public static int orangesRotting(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Pair p = q.poll();

                for(int[] dir: dirs){
                    int r = p.rows + dir[0];
                    int c = p.cols + dir[1];

                    if(r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.add(new Pair(r, c));
                        fresh--;
                    }
                }
            }
            time++;
        }
        return (fresh == 0) ? time : -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        int time = orangesRotting(grid);
        System.out.println("Final Answer: " + time);
    }
}