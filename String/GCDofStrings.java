package String;

/*
1071. Greatest Common Divisor of Strings
 */
public class GCDofStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        GCDofStrings obj = new GCDofStrings();
        System.out.println(obj.gcdOfStrings(str1, str2));
    }

    public String gcdOfStrings(String str1, String str2) {
        int l1= str1.length();
        int l2= str2.length();

        if(l1==0){
            return str2;
        }
        if(l1<l2){
            return gcdOfStrings(str2,str1);
        }
        if(!str1.startsWith(str2)){
            return "";
        }

        return gcdOfStrings(str1.substring(l2,l1),str2);
    }
}
