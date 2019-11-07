package Array;

public class MaxSumTwoNoOverlap {
    public static void main(String[] args) {
        int[] A = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int L = 1;
        int M = 2;
        System.out.println(MaxSumTwoNoOverlap.maxSumTwoNoOverlap(A, L, M));
    }

    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int answer = 0;
        int s1 = 0;
        int s2 = 0;


        for (int i = 0; i < A.length - M - L; i++) {
            int total = 0;
            for (int j = i; j < i + L; j++) {
                total += A[j];
            }
            s1 = total;
            s2 = combinations(A, s1, i + L, A.length - M - L, M);

            answer = Math.max(s1 + s2, answer);
        }
        /*s1 = s2 = 0;

        for (int i = A.length - 1; i > M + L; i--) {
            int total = 0;
            for (int j = i; j > i - L; j--) {
                total += A[j];
            }
            s1 = total;
            total = 0;
            for (int k = i - L; k > i - L - M; k--) {
                total += A[k];
            }
            s2 = total;
            answer = Math.max(s1 + s2, answer);
        }*/
        return answer;
    }

    public static int combinations(int[] A, int s1, int start, int end, int M) {
        int sum = 0;

        for (int i = start; i < end; i++) {

        }

        return sum;
    }
}
