package Stack;

public class BacspaceCompareString {

    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";
        System.out.println(backspaceCompare(S, T));

    }

    public static boolean backspaceCompare(String S, String T) {

        return returnString(S).equals(returnString(T));

    }

    public static String returnString(String str) {

        char[] c = new char[str.length()];
        int top = -1;
        for(char ch:str.toCharArray()){
            if(ch!='#'){
                top++;
                c[top]=ch;
            }
            else if(top!=-1){
                top--;
            }

        }
        return new String(c).substring(0, top+1 );

    }
}
