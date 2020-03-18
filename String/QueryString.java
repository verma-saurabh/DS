package String;

import Array.QueensAttacktheKing;

public class QueryString {
    public static void main(String[] args) {
        String S="0110";
        int N=3;
        System.out.println(QueryString.queryString(S,N));
    }
    public static boolean queryString(String S, int N) {

        boolean isQueryString = false;
        int sum = 0;
        for (int i = S.length()-1; i>=0; i--) {
            int digit = Integer.parseInt(S.substring(i, i+1));
            sum = (int)(sum + Math.pow(2, S.length()-i-1) * digit);
            if(sum>N){
                break;
            }else if (sum==N){
                isQueryString = true;
                break;
            }
        }
        return isQueryString;
    }
}
