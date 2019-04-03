package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TimesInput {
    static Scanner scan = new Scanner(System.in);
    private static final String INPUT_TIMES_TEXT = "시도할 횟수는 몇회인가요";

    /**
     * 횟수를 입력받아 반환
     * @return 횟수
     */
    public static int getTimes(){
        boolean isValidNumberInput = false;
        int times;
        times = timesInput();
        return times;
    }

    /**
     * 정수를 입력할 떄 까지 반복해서 입력 받는 함수
     */
    private static int timesInput(){
        System.out.println(INPUT_TIMES_TEXT);
        int inputInt = 0;
            try {
                inputInt = scan.nextInt();
            } catch (InputMismatchException ime) { //정수가 아닌 문자열이 들어 왔을 때 처리할 문장
                System.out.println("숫자를 입력해주세요!");
                scan.next();
                timesInput();
            }
        return inputInt;
    }

}
