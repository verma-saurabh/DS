package String;

import java.util.ArrayList;
import java.util.List;
/*
1417. Reformat The String
 */
public class ReformatString {
    public String reformat(String s) {
        int le = s.length();
        StringBuffer letters = new StringBuffer();
        StringBuffer digits = new StringBuffer();
        StringBuffer res = new StringBuffer();
        for(char c: s.toCharArray()){
            if(c >= '0' && c <='9') digits.append(c);
            else if(c >='a' && c <= 'z') letters.append(c);
        }
        if(letters.length() >= (digits.length() + 2) || (letters.length() + 2)<= digits.length()) return "";
        else{
            if(letters.length() == (digits.length() + 1)){
                res.append(letters.charAt(0));
                for(int i = 0; i < digits.length(); i++){
                    res.append(digits.charAt(i));
                    res.append(letters.charAt(i+1));
                }
            }
            else if(letters.length() == (digits.length() - 1)){
                res.append(digits.charAt(0));
                for(int i = 0; i < letters.length(); i++){
                    res.append(letters.charAt(i));
                    res.append(digits.charAt(i+1));
                }
            }
            else{
                for(int i = 0; i < letters.length(); i++){
                    res.append(letters.charAt(i));
                    res.append(digits.charAt(i));
                }
            }
        }
        return res.toString();
    }
}
