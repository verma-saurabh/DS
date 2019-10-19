package String;

public class BalancedStrings {
    /**
     *
     * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
     *
     * Given a balanced string s split it in the maximum amount of balanced strings.
     *
     * Return the maximum amount of splitted balanced strings.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "RLRRLLRLRL"
     * Output: 4
     * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
     * */

    public static int balancedStringSplit(String s) {

        int splitCount = 1;
        int rcount=0;
        int lcount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                rcount++;
            }
            else{
                lcount++;
            }
            if(lcount==rcount){
                splitCount++;
                rcount=0;
                lcount=0;
            }
        }

        return splitCount;


    }
}
