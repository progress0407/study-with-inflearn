package playgroundjava.honuxcalandar;

import java.util.Scanner;

import static java.lang.System.out;

public class Calendar {

    private static final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();
        String input;
        int month;

        while (true) {
            out.print("입력 (q: 종료) : ");
            input = sc.next();
            if (input.equals("q")) {
                break;
            }

            month = Integer.parseInt(input);

            if (month < 1 || month > 12) {
                out.println("1 ~ 12 사이의 숫자여야 합니다");
                continue;
            }

            out.printf("%d 월의 마지막 일: %d \n", month, cal.getMaxDaysOfMonthV2(month));
        }
        sc.close();
    }

    private int getMaxDaysOfMonth(int month) {
        return maxDays[month - 1];
    }

    private int getMaxDaysOfMonthV2(int month) {
        switch (month) {
            case 2:
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
