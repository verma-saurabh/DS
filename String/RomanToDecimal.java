package String;

import java.util.HashMap;

class RomanChars {
final HashMap<Character, Integer> map;

        RomanChars() {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        }

public HashMap<Character, Integer> getMap() {
        return map;
        }
        }

public class RomanToDecimal {
    public static HashMap<Character, Integer> map = new RomanChars().getMap();

    public static void main(String[] args) {
        String number1 = "DCCVII";
        String number2 = "DCCVIIH";
        System.out.println(RomanToDecimal.convertToDecimal(number1));
        System.out.println(RomanToDecimal.convertToDecimal(number2));

    }

    public static int convertToDecimal(String number) {
        int decimalNumber = 0;
        int length = number.length();
        for (int i = 0; i < length; i++) {

            Integer s1 = map.get(number.charAt(i));
            if(s1==null) return 0;
            if (i + 1 < length) {
                Integer s2 = map.get(number.charAt(i + 1));
                if(s2==null) return 0;
                if (s1 >= s2) {
                    decimalNumber += s1;
                } else {
                    decimalNumber += s2 - s1;
                    i++;
                }
            } else {
                decimalNumber += s1;
                i++;
            }
        }
        return decimalNumber;
    }
}
