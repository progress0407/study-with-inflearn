package playgroundjava.gugupack;

import java.util.Scanner;

import static java.lang.System.out;

public class GuguMain {

    public static void main(String[] args) {
//        implementation1();
//        implByMethod(); // 배열을 이용한 구현
//        implByClass(); // 클래스를 이용한 구현

//        requirements1();
        requirements2();
    }

    private static void requirements2() {
        Scanner sc = new Scanner(System.in);
        out.print("입력 :  ");
        String inputString = sc.nextLine();
        String[] split = inputString.split(",");

        int first = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[1]);

        GuguRequirements2.calc(first, second);
        GuguRequirements2.print();
    }

    private static void requirements1() {
        Scanner sc = new Scanner(System.in);
        out.print("입력 :  ");
        num = sc.nextInt();
        GuguRequirements1.calc(num);
        GuguRequirements1.print();
    }

    private static void implByClass() {

        Scanner sc = new Scanner(System.in);
        out.print("입력 :  ");
        num = sc.nextInt();

        Gugu.calc(num);
        Gugu.print();


    }

    private static int num = 0;

    private static void implByMethod() {

        Scanner sc = new Scanner(System.in);
        out.print("입력 :  ");
        num = sc.nextInt();
        int[] arr = new int[9 + 1];

        calcGuGu(num, arr);
        printGuGu(arr);

    }

    private static void printGuGu(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            out.printf("%d * %d = %d \n", num, i, arr[i]);
        }
    }

    private static void calcGuGu(int num, int[] arr) {
        for (int i = 1; i <= 9; i++) {
            arr[i] = num * i;
        }
    }

    private static void implementation1() {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num < 2 || num > 9)
            throw new IllegalArgumentException("2 ~ 9 사이의 숫자만 허용합니다");

        for (int i = 1; i <= 9; i++) {
            out.printf("%d * %d = %d \n", num, i, num * i);
        }
    }
}
