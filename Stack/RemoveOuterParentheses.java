package Stack;

public class RemoveOuterParentheses {

    public static void main(String[] args) {
        String S = "()()";
        System.out.println(RemoveOuterParentheses.removeOuterParentheses(S));
    }

    public static String removeOuterParentheses(String S) {
        if (S.isEmpty())
            return "";

        StringBuilder answer = new StringBuilder();
        int openP = 0, closeP = 0;
        int startIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case '(':
                    openP++;
                    break;
                case ')':
                    closeP++;
            }
            if (openP == closeP) {
                answer.append(S.substring(startIndex + 1, i));
                startIndex = i + 1;
                openP = 0;
                closeP = 0;
            }

        }


        return answer.toString();
    }
}
