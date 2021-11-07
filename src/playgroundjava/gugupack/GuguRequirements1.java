package playgroundjava.gugupack;

import static java.lang.System.out;

public class GuguRequirements1 {

    private static int[][] arr;

    public static void calc(int num) {

        arr = new int[num + 1][];

        for (int i = 2; i <= num; i++) {
            arr[i] = new int[num + 1];
        }

        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                arr[i][j] = i * j;
            }
        }
    }

    public static void print() {
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < arr[2].length ; j++) {
                out.printf("%d * %d = %d \n", i, j, arr[i][j]);
            }
        }
    }
}
