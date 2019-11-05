package String;

public class ReverseWords {
    public String reverseWords(String s) {

        String[] str = s.split(" +");
        String rev = "";
        for (int i = str.length - 1; i >= 0; i--) {
            rev = rev + str[i] + " ";
        }
        rev = rev.trim();

        return rev;
    }
}
