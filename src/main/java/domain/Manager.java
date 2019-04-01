// package domain;

import java.util.*;
import java.io.Console;

// 게임 진행 관리. 실제 게임 플레이 관련 내용은 여기에 다 있다.
public class Manager {
    /** 메소드 길이 제한 때문에, 각종 메시지 등을 상수로 빼 버림 */
    final static String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요."
            + " (이름은 쉼표(,) 기준으로 구분)";
    final static String NAME_TOO_LONG = "자동차 이름은 5글자 이내여야 합니다."
            + " 다시 입력해 주세요.";
    final static String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    final static String NOT_INT_ERROR = "올바른 숫자가 입력되지 않았습니다."
            + " 다시 입력해 주세요.";
    final static int NAME_LENGTH_LIMIT = 5;

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
    
    /** 문자열 배열 중 지정된 글자 수를 넘는 것이 없는지 테스트 */
    private static boolean isLengthOk(String[] array, int limit) {
        for (String str: array) {
            if (str.length() > limit) {
                return false;
            }
        }
        return true;
    }
    
    /** 입력된 문자열이 오직 0부터 9 사이의 숫자로만 이루어졌는지 테스트 */
    private static boolean isOnlyNumber(String string) {
        for (int i = 0, j; i < string.length(); i++) {
            j = string.charAt(i) - '0'; // type casting (char -> int)
            if (j < 0 || j > 9) {
                return false;
            }
        }
        return true;
    }
    
    /** 자동차 이름을 입력받고, 5글자 제한을 실제로 적용하는 메소드 */
    private static String[] getCarNames() {
        String[] result = getInput(INPUT_CAR_NAME);
        boolean check = isLengthOk(result, NAME_LENGTH_LIMIT);
        
        // 이름 글자 수 초과시 계속 재입력 요구
        while (!check) {
            result = getInput(NAME_TOO_LONG);
            check = isLengthOk(result, NAME_LENGTH_LIMIT);
        }
        
        return result;
    }
    
    /** 시도할 횟수를 입력받아 정수로 반환. */
    private static int getTryCount() {
        String temp = getInput(INPUT_TRY_COUNT)[0];
        boolean check = isOnlyNumber(temp);
        
        // 숫자로 parse할 수 없는 문자가 입력되면 계속 재입력 요구
        while (!check) {
            temp = getInput(NOT_INT_ERROR)[0];
            check = isOnlyNumber(temp);
        }
        
        return Integer.parseInt(temp);
    }

    public static void main(String[] args) {
        // 메소드 테스트용 공간.
        // todo
    }
}
