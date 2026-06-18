package SlidingWindow;
import java.util.*;

public class MaxSubarraySumk {
    public static int maxSubarraySum(int[] nums, int k){
        int maxSum = 0;
        int sum = 0;

        int i = -1;
        int j = -1;

        int n = nums.length-1;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(i < nums.length-1){
                f1 = true;
                i++;
                int x = nums[i];
                sum += x;
                map.put(x, map.getOrDefault(x, 0)+1);
                if(i-j == k){
                    if(map.size() == k){
                        maxSum = Math.max(sum, maxSum);
                    }
                    break;
                }
            }
            while(j < i){
                f2 = true;
                j++;
                int x = nums[j];
                sum -= x; //to avoid the sum of released elements
                map.put(x, map.get(x)-1);
                if(map.get(x) == 0){
                    map.remove(x);
                }
                if(i - j < k){
                    break;
                }
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
        return maxSum;
    }
    public static void main(String[] args){
        int[] nums = {100, 200, 300, 400};
        int k = 2;
        int sum = maxSubarraySum(nums, k);
        System.out.println(sum);
    }
}
