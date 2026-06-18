package SlidingWindow;
import java.util.*;

public class LongSubWithoutRepeat {
    public static int longestSubstringWithoutRepeatingChar(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int ans = 0;

        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(i < str.length()-1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                if(map.get(ch) == 2){
                    break;
                }else{
                    int len = i - j;
                    if(ans < len){
                        ans = len;
                    }
                }
            }

            while(j < i){
                f2 = true;
                j++;
                char ch = str.charAt(i);
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 1){
                    break;
                }
            }

            if(f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "ababbbacd";
        System.out.println(longestSubstringWithoutRepeatingChar(str));
    }
}
