package String;

public class GoatLanguage {
    public String toGoatLatin(String S) {

        StringBuilder answer= new StringBuilder();
        for(int i=0;i<S.split(" ").length;i++){
            String str = S.split(" ")[i];
            if(str.charAt(0)!='a'
                    &&S.charAt(0)!='e'
                    &&S.charAt(0)!='i'
                    &&S.charAt(0)!='o'&&S.charAt(0)!='u'){
                char first = str.charAt(0);
                for(int j=0;j<str.length()-1;j++){
                    answer.append(j+1);
                }
                answer.append(first);
            }

            answer.append("ma");
            for(int k=0;k<i;k++){
                answer.append("a");
            }
            answer.append(" ");
        }
        return answer.toString().trim();
    }
}
