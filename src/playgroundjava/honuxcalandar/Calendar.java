package playgroundjava.honuxcalandar;

import java.util.Scanner;

import static java.lang.System.out;

public class Calendar {

    private static final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.print("입력: ");
        int month = sc.nextInt();

        Calendar cal = new Calendar();

        out.printf("%d 월의 마지막 일: %d \n", month, cal.getMaxDaysOfMonth(month));
        sc.close();
    }

    private int getMaxDaysOfMonth(int month) {
        return maxDays[month - 1];
    }
}
