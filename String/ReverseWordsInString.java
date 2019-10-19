package String;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(ReverseWordsInString.reverseWords(s));
    }

    public static String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        for (String str : s.split(" ")) {
            for (int i = str.length() - 1; i >= 0; i--) {
                answer.append(str.charAt(i));
            }
            answer.append(" ");
        }

        return answer.toString().substring(0, s.length());

    }
}
