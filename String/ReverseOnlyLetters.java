package String;

/*
917. Reverse Only Letters

 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String str = "Test1ng-Leet=code-Q!";
        ReverseOnlyLetters obj = new ReverseOnlyLetters();
        System.out.println(obj.reverseOnlyLetters(str));
    }

    public String reverseOnlyLetters(String S) {
        StringBuilder builder = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                builder.append(S.charAt(j));
                j--;
            } else {
                builder.append(S.charAt(i));
            }
        }
        return builder.toString();
    }
}
