package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TimesInput {
    static Scanner scan = new Scanner(System.in);
    private static final String INPUT_TIMES_TEXT = "시도할 횟수는 몇회인가요";
    private static final String WRONG_INPUT_NUMBER = "숫자를 입력해주세요!";
    private static final String SMALL_INPUT_NUMBER = "0보다 큰 숫자를 입력해주세요";

    /**
     * 횟수를 입력받아 반환
     * @return 횟수
     */
    public static int getTimes(){
        boolean isValidNumberInput = false;
        int times;
        do{
            times = timesInput();
            isValidNumberInput = validateNumberInput(times);
        }while(isValidNumberInput == false);

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
            } catch (InputMismatchException ime) {
                //정수가 아닌 문자열이 들어 왔을 때 에러 캐치
                System.out.println(WRONG_INPUT_NUMBER);
                scan.next();
                timesInput();
            }
        return inputInt;
    }

    /**
     * 유효한 횟수 입력값인지 확인.
     * @param times number
     */
    private static boolean validateNumberInput(int number){
        if (number < Constants.MIN_TIMES){
            System.out.println(SMALL_INPUT_NUMBER);
            return false;
        }
        return true;
    }

}
