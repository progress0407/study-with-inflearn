package playgroundjava.honuxcalandar;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.lang.System.out;

public class Calendar {

    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAD_MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 해당 연월의 시작일 구하기
    public int getStartDayOfWeek(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int dayOfWeek = date.getDayOfWeek().getValue();
        return dayOfWeek == 7 ? 0 : dayOfWeek;
    }

    public boolean isLeapYearV2(int year) { // 강사님이 만든 것
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public boolean isLeapYear(int year) { // 내가 만든 것
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public void printSampleCalendar(int year, int month) {

        int maxDaysOfMonth = getMaxDaysOfMonthV2(year, month);
        int startWeek = getStartDayOfWeek(year, month);

        out.printf("   << %4d년 %3d일 >> \n", year, month);
        out.println(" SU MO TU WE TH FR SA");
        out.println("---------------------");

        for (int i = 0; i < startWeek; i++) {
            out.printf("   ");
        }

        int n = 1;
        while (n <= maxDaysOfMonth) {
            out.printf("%3d", n);
            if ((startWeek + n) % 7 == 0) {
                out.println();
            }
            n++;
        }
        out.print("\n\n");
    }

    private int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYearV2(year)) {
            return LEAD_MAX_DAYS[month - 1];
        }
        return MAX_DAYS[month - 1];
    }

    private int getMaxDaysOfMonthV2(int year, int month) {
        switch (month) {
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                }
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
