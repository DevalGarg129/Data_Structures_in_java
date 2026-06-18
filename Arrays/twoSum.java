import java.util.*;

public class twoSum {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    public static int[] TwoSum(int[] arr, int target){
        int n = arr.length;
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < pairs.length; i++){
            pairs[i] = new Pair(arr[i], i);
        }

        int lt = 0;
        int ri = pairs.length-1;
        int[] res = new int[2];

        Arrays.sort(pairs);
        while(lt < ri){
            int left = pairs[lt].val;
            int right = pairs[ri].val;

            if(left + right > target){
                ri--;
            }
            else if(left + right < target){
                lt++;
            }
            else{
                res[0] = pairs[lt].idx;
                res[1] = pairs[ri].idx;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] ans = TwoSum(arr, target);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
