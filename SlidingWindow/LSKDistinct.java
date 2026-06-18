//longest subarray with k distinct elements
import java.util.*;
public class LSKDistinct {
    public static int solution(int[] arr, int k){
        int maxLen = 0;
        int i = -1;
        int j = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(i < arr.length - 1){
                f1 = true;
                i++;
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

                if(map.size() <= k){
                    maxLen = Math.max(maxLen, i-j);
                }else{
                    break;
                }
            }

            while(j < i){
                f2 = true;
                j++;
                map.put(arr[j], map.get(arr[j]) - 1);
                if(map.get(arr[j]) == 0){
                    map.remove(arr[j]);
                }
                if(map.size() > k){
                    continue;
                }else{
                    maxLen = Math.max(maxLen, i-j);
                    break;
                }
            }
            if(!f1 && !f2){
                break;
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        int[] arr = {1,2,1,2,3};
        int k = 2;
        System.out.println(solution(arr, k));
    }
}
