package String;
/*
67. Add Binary
 */
public class AddBinaryStrings {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";

        AddBinaryStrings obj = new AddBinaryStrings();

        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();

        StringBuilder s = new StringBuilder();
        if (l1 > l2) {
            int diff = l1 - l2;
            while (diff != 0) {
                s.append("0");
                diff--;
            }
            s.append(b);
            b = s.toString();
            l2 = b.length();
        } else if (l2 > l1) {
            int diff = l2 - l1;
            while (diff != 0) {
                s.append("0");
                diff--;
            }
            s.append(a);
            a = s.toString();
            l1 = a.length();
        }

        int carry = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = l1 - 1; i >= 0; i--) {

            int x = Integer.parseInt(String.valueOf(a.charAt(i)));
            int y = Integer.parseInt(String.valueOf(b.charAt(i)));

            int sum = 0;
            sum = x + y + carry;
            if (sum == 0) {
                ans.append(0);
                carry = 0;
            } else if (sum == 1) {
                ans.append(1);
                carry = 0;
            } else if (sum == 2) {
                ans.append(0);
                carry = 1;
            } else if (sum == 3) {
                ans.append(1);
                carry = 1;
            }
        }
        if (carry == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();

    }
}
