package BackTrack;
import java.util.*;

public class NQueens {
    public static int isPossible(int[][] mat, int row, int col){
        int n = mat.length;
        
        //check this col on upper side
        for(int i = 0; i < row; i++){
            if(mat[i][col] == 1){
                return 0;
            }
        }

        //check upper diagonal on left side
        for(int i = row -1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(mat[i][j] == 1){
                return 0;
            }
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(mat[i][j] == 1){
                return 0;
            }
        }
        return 1;
    }

    public static void placeQueen(int row, int[][] mat, ArrayList<ArrayList<Integer>> result){
        int n = mat.length;
        if(row == n){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(mat[i][j] == 1){
                        ans.add(j+1);
                    }
                }
            }
            result.add(ans);
            return;
        }

        for(int i = 0; i < n; i++){
            if(isPossible(mat, row, i) == 1){
                mat[row][i] = 1;
                placeQueen(row + 1, mat, result);

                mat[row][i] = 0;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueens(int n){
        int[][] mat = new int[n][n];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        placeQueen(0, mat, result);
        return result;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<ArrayList<Integer>> result = nQueens(n);
        for(ArrayList<Integer> ans : result){
            for(int i: ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
