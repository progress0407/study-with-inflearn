package playgroundjava.honuxcalandar;

import java.util.Scanner;

import static java.lang.System.out;

public class Calandar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.print("입력: ");
        int month = sc.nextInt();
        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        out.printf("%d 월의 마지막 일: %d \n", month, maxDays[month - 1]);
        sc.close();
    }
}
