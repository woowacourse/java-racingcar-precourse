package domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * IO class - 프로그램의 실제 입출력을 담당하는 Class
 *
 * @author 김범준(ddaaac)
 * @version 1.03 2019-12-09
 */
public class IO {
    /**
     * 유효하지 않은 숫자를 나타내는 클래스 변수
     */
    private static final String INVALID_INPUT = null;

    /**
     * 값을 입력받기 위한 Scanner class
     */
    private final Scanner scan = new Scanner(System.in);

    /**
     * 자동차의 전진과정을 출력하는 메소드
     *
     * @param cars Car 객체 배열
     */
    protected void printPosition(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].printPosition();
        }
        System.out.println();
    }

    /**
     * 우승자를 출력하는 메소드
     *
     * @param winnersList 우승자 리스트
     */
    protected void printWinner(ArrayList<String> winnersList) {
        String winnersName = String.join(", ", winnersList);

        System.out.println(winnersName + "이/가 최종 우승했습니다.");
    }

    /**
     * input이 유효할때까지 입력을 받는 메소드
     *
     * @param question     출력될 질문
     * @param validPattern 유효한 패턴
     * @return 유효한 input 문자열
     */
    protected String getInputUntilValid(String question, String validPattern) {
        String input;

        while (true) {
            input = getInput(question, validPattern);
            if (input == INVALID_INPUT) {
                System.out.println("다시 입력해주세요.");
                continue;
            }
            return input;
        }
    }

    /**
     * input을 입력받는 메소드
     *
     * @param question     출력될 질문
     * @param validPattern 유효한 패턴
     * @return 유효한 입력 문자열 / 유효하지 않다면 INVALID_INPUT
     */
    private String getInput(String question, String validPattern) {
        String input;

        System.out.println(question);
        input = scan.nextLine();
        if (!input.matches(validPattern)) {
            return INVALID_INPUT;
        }
        return input;
    }
}
