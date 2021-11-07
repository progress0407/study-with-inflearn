package playgroundjava.gugupack;

import static java.lang.System.out;

public class Gugu {

    private static int[] arr = new int[9 + 1];

    public static void calc(int num) {
        for (int i = 1; i <= 9; i++) {
            arr[i] = num * i;
        }
    }

    public static void print() {
        int num = arr[1];
        for (int i = 1; i <= 9; i++) {
            out.printf("%d * %d = %d \n", num, i, arr[i]);
        }
    }
}
