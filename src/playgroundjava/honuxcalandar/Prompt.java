package playgroundjava.honuxcalandar;

import java.util.Scanner;

import static java.lang.System.out;

public class Prompt {

    private static final String YEAR_PROMPT = "YEAR> ";
    private static final String MONTH_PROMPT = "MONTH> ";
    private static final String START_WEEK_PROMPT = "WEEK> ";

    public void runPrompt() {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();

        int year;
        int month;

        int startWeek;

        while (true) {
            out.println("연도를 입력하세요! ");
            out.print(YEAR_PROMPT);
            year = sc.nextInt();

            out.println("달을 입력하세요! ");
            out.print(MONTH_PROMPT);
            month = sc.nextInt();

            if (year == -1 || month == -1) {
                break;
            }

            out.println("시작 요일을 입력하세요");
            out.print(START_WEEK_PROMPT);
            startWeek = Week.of(sc.next());

            if (month < 1 || month > 12) {
                out.println("1 ~ 12 사이의 숫자여야 합니다");
                continue;
            }

//            out.printf("%d월의 마지막 일: %d \n", month, cal.getMaxDaysOfMonthV2(month));
            cal.printSampleCalendar(year, month, startWeek);
        }
        sc.close();
    }

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.runPrompt();
//        prompt.runLeapYearTest();
    }

    private void runLeapYearTest() {
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();
        int year;

        while (true) {
            out.print(YEAR_PROMPT);
            year = sc.nextInt();

            if (year == -1) {
                break;
            }

//            boolean leapYear = cal.isLeapYear(year);
            boolean leapYear = cal.isLeapYearV2(year);
            if (leapYear) {
                out.println("윤년입니다");
            } else {
                out.println("평년입니다");
            }
        }

        sc.close();
    }
}
