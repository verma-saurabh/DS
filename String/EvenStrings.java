package String;

public class EvenStrings {
    public static void main(String[] args) {
        String str = "9384";
        System.out.println(getStringWithEvenSum(str));
    }

    public static int getStringWithEvenSum(String s) {
        String ans = "";

        int left = 0;
        int right = 1;

        while (left < right) {
            if (Integer.valueOf(s.charAt(right)) % 2 == 0) {
                String subString = s.substring(left, right - 1);
                int length = subString.length();
                int leftHalf = Integer.valueOf(subString.substring(left, length / 2));
                int rightHalf = Integer.valueOf(subString.substring(length / 2, length));

                if (getSum(leftHalf) == getSum(rightHalf)) {
                    ans = ans + subString;
                    break;
                } else {
                    left = left + 1;
                    if (right >= s.length() - 1) {

                    } else {
                        right = right + 1;
                    }

                }
            } else {
                right = right + 2;
            }

        }
        return ans.length();
    }

    public static int getSum(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number = number / 10;

        }
        return sum;
    }
}
