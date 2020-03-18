package Array;

public class MaxTurbulenceSize {

    public static void main(String[] args) {
        int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        MaxTurbulenceSize obj = new MaxTurbulenceSize();
        System.out.println(obj.maxTurbulenceSize(A));
    }

    public int maxTurbulenceSize(int[] A) {
        int finalCount = 0, count = 0;
        boolean firstPattern = true;
        if (A[0] > A[1]) {
            for (int i = 0; i < A.length - 1; i++) {


                if (i % 2 == 0) {
                    if (A[i] >= A[i + 1]) {
                        count++;
                    } else {
                        count = 0;
                    }

                } else {
                    if (A[i] <= A[i + 1]) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                finalCount = Math.max(finalCount, count);
            }
        } else {
            for (int i = 0; i < A.length - 1; i++) {


                if (i % 2 == 0) {
                    if (A[i] <= A[i + 1]) {
                        count++;
                    } else {
                        count = 0;
                    }

                } else {
                    if (A[i] >= A[i + 1]) {
                        count++;
                    } else {
                        count = 0;
                    }
                }
                finalCount = Math.max(finalCount, count);
            }
        }
        for (int i = 0; i < A.length - 1; i++) {


            if (i % 2 == 0) {
                if (A[i] <= A[i + 1]) {
                    count++;
                } else {
                    count = 0;
                }

            } else {
                if (A[i] >= A[i + 1]) {
                    count++;
                } else {
                    count = 0;
                }
            }
            finalCount = Math.max(finalCount, count);
        }
        return finalCount;
    }
}
