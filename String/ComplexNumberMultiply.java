package String;

public class ComplexNumberMultiply {


    public String complexNumberMultiply(String a, String b) {

        StringBuilder answer = new StringBuilder();
        int x, y, u, v;

        x = Integer.parseInt(a.split("\\+")[0]);
        y = Integer.parseInt(a.split("\\+")[1].split("i")[0]);
        u = Integer.parseInt(b.split("\\+")[0]);
        v = Integer.parseInt(b.split("\\+")[1].split("i")[0]);
        answer.append(x * u - y * v);
        answer.append("+");
        answer.append(x * v + y * u);
        answer.append("i");

        return answer.toString();
    }
}
