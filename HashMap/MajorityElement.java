package HashMap;
import java.util.*;

public class MajorityElement {
    public static ArrayList<Integer> majorElement(int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int threshold = n / 3;

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int element = entry.getKey();
            int count = entry.getValue();

            if(count > threshold){
                ans.add(element);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> ans = majorElement(arr);
        System.out.println(ans);

    }
}
