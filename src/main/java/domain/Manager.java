// package domain;

import java.util.*;
import java.io.Console;

// 게임 진행 관리. 실제 게임 플레이 관련 내용은 여기에 다 있다.
public class Manager {
    /** 메소드 길이 제한 때문에, 각종 메시지 등을 상수로 빼 버림. */
    final static String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요."
            + " (이름은 쉼표(,) 기준으로 구분)";
    final static String NAME_TOO_LONG = "자동차 이름은 5글자 이내여야 합니다."
            + " 다시 입력하세요.";
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
    private static boolean checkLengthRegulation(String[] array, int limit) {
        for (String str: array) {
            if (str.length() > limit) {
                return false;
            }
        }
        
        return true;
    }
    
    /** 자동차 이름을 입력받고, 5글자 제한을 실제로 적용하는 메소드. */
    private static String[] getCarNames() {
        String[] result = getInput(INPUT_CAR_NAME);
        boolean check = checkLengthRegulation(result, NAME_LENGTH_LIMIT);
        
        // 이름 글자 수 초과시 계속 재입력 요구
        while (!check) {
            result = getInput(NAME_TOO_LONG);
            check = checkLengthRegulation(result, NAME_LENGTH_LIMIT);
        }
        
        return result;
    }

    public static void main(String[] args) {
        // 메소드 테스트용 공간.
        // todo

        String[] test = getCarNames();
        for (String a: test) {
            System.out.println(a);
        }
    }
}
