package String;

public class CustomSortString {


    public  String customSortString(String S, String T) {


        int[] freq = new int[26];

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            freq[c - 'a']++;
        }

        // step 2: scan the string S and print the number of chars in T
        //
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            while (freq[c - 'a'] > 0) {
                sb.append(c);
                freq[c - 'a']--;
            }
        }

        // step 3: scan the freq again and append anything not zero
        //
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return sb.toString();
    }
}
