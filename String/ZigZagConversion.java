package String;

import java.util.ArrayList;
import java.util.List;

/*
6. ZigZag Conversion
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {

        if(numRows==1) return s;
        int n= s.length();

        List<StringBuilder> rows= new ArrayList<>();

        for(int i=0;i<Math.min(numRows, n);i++){
            rows.add(new StringBuilder());
        }

        boolean goingdown = false;
        int curRow=0;

        for(char c:s.toCharArray()){
            rows.get(curRow).append(c);

            if(curRow==0||curRow==numRows-1){
                goingdown=!goingdown;
            }

            curRow+=goingdown ? 1: -1;

        }
        StringBuilder ans= new StringBuilder();

        for(StringBuilder row:rows){
            ans.append(row);
        }

        return ans.toString();

    }
}
