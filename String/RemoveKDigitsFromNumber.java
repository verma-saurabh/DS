package String;

public class RemoveKDigitsFromNumber {
    public static void main(String[] args) {
        String num = "112";
        RemoveKDigitsFromNumber obj = new RemoveKDigitsFromNumber();
        System.out.println(obj.removeKdigits(num, 1));
    }

    public String removeKdigits(String num, int k) {
        int l = num.length();

        if (k >= l) {
            return "0";
        }

        int min = Integer.MAX_VALUE;
        int left = 0, right = k;
        for (int i = 0; i < l - k+1; i++) {
            String temp = num;
            temp = temp.substring(0, left) + temp.substring(right, l);
            min = Math.min(min, Integer.parseInt(temp));
            left++;
            right++;
        }

        return String.valueOf(min);

    }
}
