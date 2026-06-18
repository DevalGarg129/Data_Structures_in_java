import java.util.*;

public class containsDuplicate {
    public static boolean duplicates(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args){
        int[] nums = {1,2,2,3,4,5,2,9};
        boolean ans = duplicates(nums);
        System.out.println(ans);
    }
}
