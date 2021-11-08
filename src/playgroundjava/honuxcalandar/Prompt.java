package playgroundjava.honuxcalandar;

import java.util.Scanner;

import static java.lang.System.out;

public class Prompt {

    private static final String YEAR_PROMPT = "YEAR> ";
    private static final String MONTH_PROMPT = "MONTH> ";
//    private static final String START_WEEK_PROMPT = "WEEK> ";

    public void printMenu() {
        out.println("+-------------------+");
        out.println("| 1. 일정 등록");
        out.println("| 2. 일정 검색");
        out.println("| 3. 달력 보기");
        out.println("| h. 검색   q. 종료");
        out.println("+-------------------+");
    }

    public void runPrompt() {
        printMenu();
        Scanner sc = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true) {
            out.println("명령 (1, 2, 3, h, q)");
            String input = sc.next();

            switch (input) {
                case "1":
                    cmdRegister(sc, cal);
                    break;
                case "2":
                    cmdSearch(sc, cal);
                    break;
                case "3":
                    cmdCalendar(sc, cal);
                    break;
                case "h":
                    printMenu();
                    break;
            }
            if (input.equals("q")) {
                break;
            }
        }
        sc.close();
    }

    private void cmdRegister(Scanner sc, Calendar cal) {
        out.println("[일정 등록]");
        out.print("날짜를 입력해주세요 (yyyy-MM-dd)");
        String strDate = sc.next();
        out.print("일정을 입력해 주세요");
        String strPlan = sc.next();
        sc.nextLine();
        cal.registerPlan(strDate, strPlan);
    }

    private void cmdSearch(Scanner sc, Calendar cal) {
        out.println("[일정 검색]");
        out.print("날짜를 입력해주세요 (yyyy-MM-dd)");
        String strDate = sc.next();
        String plan = cal.searchPlan(strDate);
        if (plan == null) {
            out.println("일정이 없습니다.");
        } else {
            out.println("일정: " + plan);
        }
    }

    private void cmdCalendar(Scanner sc, Calendar cal) {

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
                return;
            }
/*
            out.println("첫째 날의 요일을 입력하세요 (su, mo, tu, we, th, fr, sa)");
            out.print(START_WEEK_PROMPT);
            startWeek = Week.of(sc.next());
*/
            if (month < 1 || month > 12) {
                out.println("1 ~ 12 사이의 숫자여야 합니다");
                continue;
            }
//            out.printf("%d월의 마지막 일: %d \n", month, cal.getMaxDaysOfMonthV2(month));
            cal.printSampleCalendar(year, month);
        }
    }

    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.runPrompt();
//        prompt.runLeapYearTest();
//        prompt.calcGetWeekDayTest();
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

            boolean leapYear = cal.isLeapYear(year);
//            boolean leapYear = cal.isLeapYearV2(year);
            if (leapYear) {
                out.println("윤년입니다");
            } else {
                out.println("평년입니다");
            }
        }

        sc.close();
    }

    private void calcGetWeekDayTest() {
        Calendar cal = new Calendar();
        out.println(cal.getStartDayOfWeekV2(1970, 1) == 4);
        out.println(cal.getStartDayOfWeekV2(1971, 1) == 5);
        out.println(cal.getStartDayOfWeekV2(1972, 1) == 6);
        out.println(cal.getStartDayOfWeekV2(1973, 1) == 1);
        out.println(cal.getStartDayOfWeekV2(1974, 1) == 2);
    }
}
