package BackTrack;
import java.util.*;

public class validSudoku {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = scn.next().charAt(0);
            }
        }

        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] boxes = new boolean[n][n];

        boolean valid = true;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(board[row][col] == '.'){
                    continue;
                }

                int num = board[row][col] - '1';

                int box = (row / 3) * 3 + (col / 3);

                if(rows[row][num] || cols[col][num] || boxes[box][num]){
                    valid = false;
                    break;
                }

                rows[row][num] = true;
                cols[col][num] = true;
                boxes[box][num] = true;
            }
            if(!valid){
                break;
            }
        }
        System.out.println(valid);
        scn.close();
    }    
}
