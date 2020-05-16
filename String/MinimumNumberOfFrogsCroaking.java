package String;

public class MinimumNumberOfFrogsCroaking {
    public static void main(String[] args) {
        String croakOfFrogs = "croakcroak";
        MinimumNumberOfFrogsCroaking obj = new MinimumNumberOfFrogsCroaking();
        System.out.println(obj.minNumberOfFrogs(croakOfFrogs));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int l = croakOfFrogs.length();
        if (l % 5 != 0) {
            return -1;
        }
        int ans = 0;

        String temp = croakOfFrogs;

        char[] sequence = "croak".toCharArray();
        int i = 0;
        int j = 0;
        while (i < temp.length()) {
            while (i < temp.length() && (temp.charAt(i) != sequence[j])) {
                i++;
            }
            j++;
            if (j == sequence.length) {
                j = 0;
                ans++;
            }
        }
        if (j < sequence.length && i > temp.length()) {
            return -1;
        }
        int subsetLen = gcdOfStrings(croakOfFrogs, "croak").length();
        return Math.max(ans, subsetLen > 0 ? 1 : 0);
    }

    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        if (l1 == 0) {
            return str2;
        }
        if (l1 < l2) {
            return gcdOfStrings(str2, str1);
        }
        if (!str1.startsWith(str2)) {
            return "";
        }

        return gcdOfStrings(str1.substring(l2, l1), str2);
    }
}
