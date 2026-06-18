package DynammicProgramming;
import java.util.*;

public class CoinChangeCombination {
    public static int coinChange(int[] coins, int amount){
        int n = coins.length;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int coin: coins){
            for(int j = coin; j <= amount; j++){
                dp[j] = Math.min(dp[j], dp[j-coin] + 1);
            }
        }
        if(dp[amount] > amount) return -1;
        return dp[amount];
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the number of coins:");
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
