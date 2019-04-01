package domain;

import java.util.*;
import java.io.Console;

public class Manager {
    // 게임 진행 관리. 실제 게임 플레이 관련 내용은 여기에 다 있다.

    /** 0에서 9 사이의 임의의 정수 하나를 생성하여 반환 */
    private static int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10);
    }

    /** 문자열을 입력받아, 쉼표를 기준으로 나누어 문자열 배열로 반환 */
    private static String[] getNames(String message) {
        Console console = System.console();
        String inputData = console.readLine(message + "\n"); // 메시지 출력
        return inputData.split(",\\s*"); // 정규 표현식 적용 - 띄어쓰기 때문
    }

    public static void main(String[] args) {
        // 메소드 테스트용 공간.
        // todo
        // System.out.println(getRandomInt());
        // String[] test = getNames("test");
        // for (String a: test) {
        //     System.out.println(a);
        // }
    }
}
