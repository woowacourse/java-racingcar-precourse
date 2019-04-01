package domain;

import java.util.*;
import java.io.Console;

// 게임 진행 관리. 실제 게임 플레이 구현에 필요한 기능은 여기에 다 있다.
public class Manager {
    /** 메소드 길이 제한 때문에, 각종 메시지나 값을 상수로 빼 버림 */
    final static String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요."
            + " (이름은 쉼표(,) 기준으로 구분)";
    final static String NAME_TOO_LONG = "자동차 이름은 5글자 이내여야 합니다."
            + " 다시 입력해 주세요.";
    final static String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    final static String NOT_INT_ERROR = "올바른 숫자가 입력되지 않았습니다."
            + " 다시 입력해 주세요.";
    final static int NAME_LENGTH_LIMIT = 5;
    final static int FORWARD_CRITERION = 4;
    
    /** 0에서 9 사이의 임의의 정수 하나를 생성하여 반환 */
    private static int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10);
    }
    
    /** 문자열을 입력받아, 쉼표를 기준으로 나누어 문자열 배열로 반환 */
    private static String[] getInput(String message) {
        Console console = System.console();
        String inputData = console.readLine(message + "\n"); // 메시지 출력
        return inputData.split(",\\s*"); // 정규 표현식 적용 - 띄어쓰기 때문
    }
    
    /** 문자열 배열 중 글자 수에 문제는 없는지 테스트 */
    private static boolean isLengthOk(String[] array, int limit) {
        int length;
        for (String str: array) {
            length = str.length();
            if (length > limit || length == 0) {
                return false;
            }
        }
        return true;
    }
    
    /** 입력된 문자열이 오직 0부터 9 사이의 숫자로만 이루어졌는지 테스트 */
    private static boolean isOnlyNumber(String string) {
        int length = string.length();
        
        if (length == 0) {
            return false; // 빈 문자열은 취급하지 않는다.
        }
        
        for (int i = 0, j; i < length; i++) {
            j = string.charAt(i) - '0'; // type casting (char -> int)
            if (j < 0 || j > 9) {
                return false;
            }
        }
        
        return true;
    }
    
    /** 자동차 이름을 입력받고, 5글자 제한을 실제로 적용하는 메소드 */
    public static String[] getCarNames() {
        String[] result = getInput(INPUT_CAR_NAME);
        boolean check = isLengthOk(result, NAME_LENGTH_LIMIT);
        
        // 이름 글자 수에 문제가 있으면 계속 재입력 요구
        while (!check) {
            result = getInput(NAME_TOO_LONG);
            check = isLengthOk(result, NAME_LENGTH_LIMIT);
        }
        
        return result;
    }
    
    /** 시도할 횟수를 입력받아 정수로 반환. */
    public static int getTryCount() {
        String temp = getInput(INPUT_TRY_COUNT)[0];
        boolean check = isOnlyNumber(temp);
        
        // 입력에 문제가 있으면 계속 재입력 요구
        while (!check) {
            temp = getInput(NOT_INT_ERROR)[0];
            check = isOnlyNumber(temp);
        }
        
        return Integer.parseInt(temp);
    }
    
    /** 자동차 객체를 랜덤으로 전진시킨다 */
    public static void randomForward(Car car) {
        if (getRandomInt() >= FORWARD_CRITERION) {
            car.moveForward();
        }
    }

    // public static void main(String[] args) {
    //     // 메소드 테스트용 공간.
    // }
}
