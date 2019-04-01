/*
 * @(#)Main.java        0.1 2019/04/01
 *
 *
 */

package domain;

import java.util.Scanner;

/**
 * 자동차 경주 게임을 위한 클래스 입니다.
 *
 * @author 반선호
 * @version 0.1 2019년 4월 01일
 */
public class RacingCarGame {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 0;
    private static final String INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String BLANK_ERROR_MESSAGE = "공백으로만 이루어진 이름을 생성할 수 없습니다. 다시 입력해 주새요";
    private static final String LENGTH_ERROR_MESSAGE = "길이가 5보다 큽니다. 다시 입력해 주새요";

    private String[] carNames;
    private Car[] cars;

    private Scanner scanner = new Scanner(System.in);

    public void gameStart() {
        requestCarName();
        createCar();
    }

    private void requestCarName() {
        String answer;
        do {
            System.out.println(INPUT_REQUEST_MESSAGE);
            answer = scanner.nextLine();
            carNames = splitCarName(answer);
            trimCarName();
        } while (isLessThanFive() || isLagerThanZero());
    }

    private String[] splitCarName(String answer) {
        return answer.split(",");
    }

    private void trimCarName() {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private boolean isLagerThanZero() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() == MINIMUM_NAME_LENGTH) {
                System.out.println(BLANK_ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private boolean isLessThanFive() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > MAXIMUM_NAME_LENGTH) {
                System.out.println("[" + carNames[i] + "]" + LENGTH_ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private void createCar() {
        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }
}
