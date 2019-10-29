package String;

public class GoatLanguage {
    public static void main(String[] args) {
        String S = "Each word consists of lowercase and uppercase letters only";

        System.out.println(GoatLanguage.toGoatLatin(S));
    }

    public static String toGoatLatin(String S) {

        StringBuilder answer= new StringBuilder();
        for(int i=0;i<S.split(" ").length;i++){
            String str = S.split(" ")[i];
            if(str.charAt(0)!='a'&&str.charAt(0)!='A'
                    &&str.charAt(0)!='e' &&str.charAt(0)!='E'
                    &&str.charAt(0)!='i'&&str.charAt(0)!='I'
                    &&str.charAt(0)!='o'&&str.charAt(0)!='O'
                    &&str.charAt(0)!='u'&&str.charAt(0)!='U'){
                char first = str.charAt(0);
                for(int j=0;j<str.length()-1;j++){
                    answer.append(str.charAt(j+1));
                }
                answer.append(first);
            }
            else{
                for(int j=0;j<str.length();j++){
                    answer.append(str.charAt(j));
                }
            }

            answer.append("ma");
            for(int k=0;k<=i;k++){
                answer.append("a");
            }
            answer.append(" ");
        }
        return answer.toString().trim();
    }
}
