import java.util.*;
class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class numOfIslands {
    public void dfs(char[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    public int numIslands(char[][] grid){
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        char[][] grid = new char[n][m];

        for(int i = 0; i < n; i++){
            String str = scn.next();
            for(int j = 0; j < m; j++){
                grid[i][j] = str.charAt(j);
            }
        }
        numOfIslands obj = new numOfIslands();
        int answer = obj.numIslands(grid);
        System.out.println(answer);
    }    
}
