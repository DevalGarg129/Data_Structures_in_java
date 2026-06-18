package HashMap;
import java.util.*;

public class IsomorphicString {
    public static boolean isIsomorphic(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Boolean> map2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(map1.containsKey(ch1) == true){
                if(map1.get(ch1) != ch2){
                    return false;
                }
            }
            else{
                if(map2.containsKey(ch2) == true){
                    return false;
                }else{
                    map1.put(ch1, ch2);
                    map2.put(ch1, true);
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String s1 = scn.next();
        String s2 = scn.next();

        boolean answer = isIsomorphic(s1, s2);
        System.out.println(answer);
    }
}
