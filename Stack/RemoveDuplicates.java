package Stack;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String S = "abbaca";
        System.out.println(RemoveDuplicates.removeDuplicates(S));
    }

    public static String removeDuplicates(String S) {

        char[] statck = new char[S.length()];
        int top = -1;
        int i = 0;
        statck[i] = S.charAt(i);
        top++;
        for (i = 1; i < S.length(); i++) {
            if (top == -1) {
                statck[top + 1] = S.charAt(i);
                top++;
                continue;
            }
            if (statck[top] == S.charAt(i)) {
                top--;
            } else {
                top++;
                statck[top] = S.charAt(i);
            }

        }

        return new String(statck).substring(0, top+1);
    }
}
