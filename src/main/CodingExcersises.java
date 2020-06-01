import java.util.Arrays;

public class CodingExcersises {

    public static void main(String args[]) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int K = 4;

        System.out.println("-");

        System.out.println("Find Gap:");
        System.out.println(findGap(5));

        System.out.println("-");
        System.out.println("Cyclic rotation:");
        System.out.println(Arrays.toString(cyclicRotation(A, K)));

        System.out.println("-");

        A = new int[]{1, 3, 1, 3, 1, 7, 1};
        System.out.println("Odd occurrences:");
        System.out.println(oddOccurrences(A));

        System.out.println("-");

        System.out.println("Frog jump:");
        System.out.println(frogJump(10,85,30));

        System.out.println("-");

        System.out.println("Permutation missing element:");
        System.out.println(permMissingElement(new int[]{}));

        System.out.println("-");

        System.out.println("Tape Equilibrium:");
        System.out.println(tapeEquilibrium(new int[]{3,1,2,4,3}));

        System.out.println("-");

        System.out.println("Frog jump:");
        System.out.println(frogJump(2, new int[]{1,2}));

        System.out.println("-");

        System.out.println("Counters:");
        System.out.println(Arrays.toString(counters(5, new int[]{3, 4, 4, 6, 1, 4, 4})));

    }

    private static int findGap(int N){
        String binary = Integer.toBinaryString(N);
        String[] gaps = binary.split("1");
        if(gaps.length == 0) return 0;
        if(binary.charAt(binary.length() -1) != '1'){
            gaps = Arrays.copyOf(gaps, gaps.length-1);
        }
        return findLargestNumber(gaps, 0, gaps.length -1);
    }

    private static int findLargestNumber(String[] input, int leftBound, int rightBound){
        if(leftBound - rightBound == 1){
            return Math.max(input[leftBound].length(), input[rightBound].length());
        }else if(leftBound == rightBound){
            return input[leftBound].length();
        }
        return Math.max(findLargestNumber(input, leftBound, (leftBound+rightBound)/2), findLargestNumber(input, (leftBound+rightBound)/2 +1, rightBound));
    }


    public static int[] cyclicRotation(int[] A, int K) {
        if (A == null || A.length == 0) return A;
        int numOfOperations = K % A.length;
        for (int i = 0; i < numOfOperations; i++) {
            int tmp = A[0];
            int first = A[A.length - 1];
            for (int j = 1; j < A.length; j++) {
                int prev = A[j];
                A[j] = tmp;
                tmp = prev;
            }
            A[0] = first;
        }
        return A;
    }

    public static int oddOccurrences(int[] A) {
        int result = 0;
        for(int c : A) result ^= c;
        return result;
    }

    public static int frogJump(int X, int Y, int D) {
        int distance = Y - X;
        if(distance <= 0) return 0;
        return (int) Math.ceil((double) distance / D);
    }

    public static int permMissingElement(int[] A) {
        long N = A.length + 1;
        long sum = N * (N + 1) / 2;
        long sumN = 0;
        for (int i = 0; i < A.length; i++) sumN += A[i];
        return (int) ((int) sum - sumN);
    }

    public static int tapeEquilibrium(int[] A) {
        long sumR = 0;
        long sumL = A[0];
        for(int i = 1; i < A.length; i++){
            sumR += A[i];
        }
        long result = Math.abs(sumL - sumR);

        for(int i = 1; i < A.length - 1; i++){
            sumL += A[i];
            sumR -= A[i];
            if(Math.abs(sumL - sumR) < result){
                result = Math.abs(sumL - sumR);
            }
        }
        return (int) result;
    }

    private static int frogJump(int X, int[] A) {
        int[] count = new int[X];
        int posTracker = 0;
        for(int i = 0; i < A.length; i++) {
            if (count[A[i] - 1] == 0) posTracker++;
            count[A[i] - 1]++;
            if (posTracker == X) {
                return i;
            }
        }
        return -1;
    }

    private static int[] counters(int N, int[] A){
        int[] result = new int[N];
        int maxValueTmp = 0;
        int maxValue = 0;
        boolean applyMax = false;
        for(int i = 0; i < A.length; i++){
            if(1 <= A[i] && A[i] <= N){
                if (result[A[i] - 1] < maxValue) {
                    result[A[i] - 1] = 1 + maxValue;
                } else {
                    result[A[i] - 1]++;
                }
                if(result[A[i] - 1] > maxValueTmp) maxValueTmp = result[A[i] - 1];
            }else if(A[i] > N){
                applyMax = true;
                maxValue = maxValueTmp;
            }
        }

        if(applyMax) {
            for (int j = 0; j < result.length; j++) {
                if (result[j] < maxValue) result[j] = maxValue;
            }
        }

        return result;
    }


}