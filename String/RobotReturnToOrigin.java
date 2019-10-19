package String;

public class RobotReturnToOrigin {

    public static void main(String[] args) {
        System.out.println(RobotReturnToOrigin.judgeCircle("UDD"));
    }

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    y++;
                    break;

                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }

        return x == 0 && y == 0;

    }
}
