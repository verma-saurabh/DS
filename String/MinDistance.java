package String;

/*
72. Edit Distance
 */
public class MinDistance {


    public int min(int a, int b, int c) {
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }

        int[][] result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = i;
        }
        for (int k = 0; k < result.length; k++) {
            for (int l = 0; l < result[0].length; l++) {
                System.out.print(result[k][l] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = 1 + min(result[i - 1][j - 1], result[i][j - 1], result[i - 1][j]);
                }
            }

            for (int k = 0; k < result.length; k++) {
                for (int l = 0; l < result[0].length; l++) {
                    System.out.print(result[k][l] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return result[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";

        MinDistance obj = new MinDistance();
        System.out.println(obj.minDistance(word1, word2));
    }
}
