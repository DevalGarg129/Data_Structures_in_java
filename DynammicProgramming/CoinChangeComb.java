package DynammicProgramming;
import java.util.*;

public class CoinChangeComb {
    public static int coinChange(int[] coins, int amount){
        int n = coins.length;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number of coins : ");
        int n = scn.nextInt();

        int[] coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = scn.nextInt();
        }

        int amount = scn.nextInt();
        int answer = coinChange(coins, amount);
        System.out.println(answer);
    }
}
