package String;

import java.util.*;

public class MinimumNumberOfBallons {
    public int maxNumberOfBalloons(String text) {

        Set<Character> set = new HashSet<Character>();
        for (char c : text.toCharArray()) {
            set.add(c);
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < text.length(); i++) {
            if(map.containsKey(text.charAt(i))){
                map.put(text.charAt(i),map.get(text.charAt(i))+1);
            }else{
                map.put(text.charAt(i),1);
            }
        }

        map.put('l',map.get('l')/2);
        map.put('l',map.get('o')/2);

        return Collections.min(map.values());
    }
}
