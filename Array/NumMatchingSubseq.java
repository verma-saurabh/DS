package Array;

public class NumMatchingSubseq {

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        NumMatchingSubseq obj = new NumMatchingSubseq();
        System.out.println(obj.numMatchingSubseq(S, words));
    }

    public int numMatchingSubseq(String S, String[] words) {
        int answer = 0;
        for (String word : words) {
            int count = 0;
            int i = 0;
            int j = 0;

            while (i < word.length() && j < S.length()) {
                if (word.charAt(i) == S.charAt(j)) {
                    count++;
                    i++;
                    j++;
                } else {
                    j++;
                }

            }
            if (count == word.length()) {
                answer++;
            }
        }
        return answer;
    }
}
