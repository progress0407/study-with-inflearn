package playgroundjava.honuxcalandar;

import java.time.LocalDate;

import static java.lang.System.out;

public class Calendar {

    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * su: 0, mo: 1 ... sa: 6
     */
    // 해당 연월의 시작일 구하기
    public int getStartDayOfWeek(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int dayOfWeek = date.getDayOfWeek().getValue();
        return dayOfWeek == 7 ? 0 : dayOfWeek;
    }

    // 강사님 방식을 차용
    public int getStartDayOfWeekV2(int year, int month) {
        int syear = 1970;
        int smonth = 1;
        int standardWeek = 4; // 1970.1.1의 시작요일은 목요일

        //  365가 아닌 7을 나눈 나머지만 계산 (평년 윤년)
        int nonLeapYearPlusRemainWeek = 1;
        int leapYearPlusRemainWeek = 2;

        for (int i = syear; i < year; i++) {
            if (isLeapYearV2(i)) {
                standardWeek += leapYearPlusRemainWeek;
                continue;
            }
            standardWeek += nonLeapYearPlusRemainWeek;
        }

        standardWeek %= 7; // 7로 나눈 나머지만 필요

/*
        if (isLeapYearV2(year)) {
            for (int i = smonth; i < month; i++) {
                standardWeek += (LEAP_MAX_DAYS[i] % 7);
            }
        } else {
            for (int i = smonth; i < month; i++) {
                standardWeek += (MAX_DAYS[i] % 7);
            }
        }
*/
        for (int i = smonth; i < month; i++) {
            standardWeek += getMaxDaysOfMonthV2(year, i);
        }

        standardWeek %= 7;

        return standardWeek;
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

//        int startWeek = getStartDayOfWeek(year, month);
        int startWeek = getStartDayOfWeekV2(year, month);

        out.printf("   << %4d년 %3d월 >> \n", year, month);
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
            return LEAP_MAX_DAYS[month];
        }
        return MAX_DAYS[month];
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
