/*
 * @(#)RacingCarGame.java        1.0 2019/04/02
 *
 *
 */

package domain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 자동차 경주 게임을 위한 클래스 입니다.
 *
 * @author 반선호
 * @version 1.0 2019년 4월 02일
 */
public class RacingCarGame {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 0;
    private static final String INPUT_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String BLANK_ERROR_MESSAGE = "공백으로만 이루어진 이름을 생성할 수 없습니다. 다시 입력해 주새요";
    private static final String LENGTH_ERROR_MESSAGE = "길이가 5보다 큽니다. 다시 입력해 주새요";
    private static final String ROUND_REQEUST_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String NUMBER_ERROR_MESSAGE = "숫자가 아닙니다. 숫자를 입력해주세요";
    private static final String RUN_START_MESSAGE = "실행 결과";
    private static final String RANK_RESULT_MESSAGE = "가 최종 우승했습니다.";
    private static final int FIRST_RANK_POSITION = 0;

    private String[] carNames;
    private Car[] cars;
    private int round;

    private Scanner scanner = new Scanner(System.in);

    public void gameStart() {
        requestCarName();
        createCar();
        requestRound();
        implementRound();
        printWinner();
    }

    private void requestCarName() {

        String answer;

        do {
            System.out.println(INPUT_REQUEST_MESSAGE);
            answer = scanner.nextLine();
            carNames = splitCarName(answer);
            trimCarName();
        } while (lessThanFive() || lagerThanZero());
    }

    private String[] splitCarName(String answer) {
        return answer.split(",");
    }

    private void trimCarName() {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private boolean lagerThanZero() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() == MINIMUM_NAME_LENGTH) {
                System.out.println(BLANK_ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    private boolean lessThanFive() {
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

    private void requestRound() {

        String answer;

        do {
            System.out.println(ROUND_REQEUST_MESSAGE);
            answer = scanner.next();
        } while (!checkNumberException(answer));
    }

    private boolean checkNumberException(String answer) {
        try {
            round = Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_ERROR_MESSAGE);
            return false;
        }
    }

    private void implementRound() {
        System.out.println();
        System.out.println(RUN_START_MESSAGE);
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < cars.length; j++) {
                cars[j].runOneCycle();
                printCurrentPosition(cars[j]);
            }
            System.out.println();
        }
    }

    private void printCurrentPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void printWinner() {
        StringBuilder stringbuilder = new StringBuilder();
        Arrays.sort(cars);
        stringbuilder.append(cars[FIRST_RANK_POSITION].getName());
        for (int i = 1; i < cars.length; i++) {
            if (cars[FIRST_RANK_POSITION].getPosition() != cars[i].getPosition()) {
                break;
            }
            stringbuilder.append(", ").append(cars[i].getName());
        }
        stringbuilder.append(RANK_RESULT_MESSAGE);
        System.out.println(stringbuilder);
    }
}
