package DynammicProgramming;
import java.util.*;

public class longestCommonSubstring {
    public static int solution(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        

        int[][] dp = new int[n+1][m+1];

        int maxLen = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String str1 = scn.next();
        String str2 = scn.next();

        int answer = solution(str1, str2);
        System.out.println(answer);

    }
}
