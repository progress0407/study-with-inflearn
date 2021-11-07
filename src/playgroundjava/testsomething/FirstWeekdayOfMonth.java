package playgroundjava.testsomething;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// 시작 요일 test
public class FirstWeekdayOfMonth {
    public static void main(String[] args) throws ParseException {

//        solution1();

//        solution2();

        solution3();
    }

    private static void solution3() {
//        LocalDate date = LocalDate.now();
        LocalDate date = LocalDate.of(2021, 10, 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("dayOfWeek.getValue() = " + dayOfWeek.getValue());
    }

    private static void solution2() {
        Calendar c = new GregorianCalendar(2021, Calendar.JANUARY, 1);
        for(int i = 0 ;i < 12 ; i++){
            System.out.println(c.getTime());
            c.add(Calendar.MONTH, 1);
        }

        System.out.println("===============");

        System.out.println(c.getTime());
    }

    private static void solution1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date nDate = dateFormat.parse("2021-11-07");

        Calendar cal = Calendar.getInstance();
        cal.setTime(nDate);

        int dayNum = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayNum);
    }
}
