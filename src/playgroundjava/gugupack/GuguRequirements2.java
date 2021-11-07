package playgroundjava.gugupack;

import static java.lang.System.out;

public class GuguRequirements2 {

    private static int[][] arr;

    private static int first;
    private static int second;

    public static void calc(int firstIn, int secondIn) {

        first = firstIn;
        second = secondIn;

        arr = new int[firstIn + 1][secondIn + 1];

        for (int i = 2; i <= firstIn; i++) {
            for (int j = 1; j <= secondIn; j++) {
                arr[i][j] = i * j;
            }
        }
    }

    public static void print() {
        int num = arr[2][1];
        for (int i = 2; i <= first; i++) {
            for (int j = 1; j <= second; j++) {
                out.printf("%d * %d = %d \n", i, j, arr[i][j]);
            }
        }
    }
}
