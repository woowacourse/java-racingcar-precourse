package racingcar.view;

import racingcar.domain.Car;
import racingcar.type.ErrorType;
import racingcar.type.TextType;

import java.util.ArrayList;

/**
 * 출력을 위한 클래스
 *
 * @author Daeun Lee
 */
public class OutputView {
    public static void printNewLine() {
        System.out.println();
    }

    public static void printCarNamesText() {
        System.out.println(TextType.CAR_NAMES_TEXT.getText());
    }

    public static void printCarRacingTimesText() {
        System.out.println(TextType.CAR_RACING_TIMES_TEXT.getText());
    }

    public static void printResultText() {
        System.out.println(TextType.RESULT_TEXT.getText());
    }

    public static void printResult(Car car, StringBuffer carPosition) {
        System.out.println(car.getName() + " : " + carPosition);
    }

    public static void printNoWinner() {
        System.out.println(ErrorType.NO_WINNER.getError());
    }

    /**
     * @param winner 자동차 경주 게임의 우승자를 원소로 가진 리스트
     */
    public static void printWinner(ArrayList<String> winner) {
        printWinnerText();

        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i != (winner.size() - 1)) {
                System.out.print(TextType.COMMA_TEXT.getText() + TextType.BLANK_TEXT.getText());
            }
        }
    }

    public static void printWinnerText() {
        System.out.print(TextType.WINNER_TEXT.getText());
    }
}
