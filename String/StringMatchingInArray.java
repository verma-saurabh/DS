package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
1408. String Matching in an Array
 */
public class StringMatchingInArray {
    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        StringMatchingInArray obj = new StringMatchingInArray();
        obj.stringMatching(words);
    }

    public List<String> stringMatching(String[] words) {
        List<String> list = Arrays.asList(words);
        Collections.sort(list, (p, q) -> p.length() - q.length());
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String word = list.get(i);
            for (int j = words.length - 1; j > i; --j) {
                if (list.get(j).contains(word)) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }

}
