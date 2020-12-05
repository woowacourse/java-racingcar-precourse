package racingcar.view;

import racingcar.Car;
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

    public static void printWinner(ArrayList<String> winner) {
        System.out.print(TextType.WINNER_TEXT.getText());
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i != (winner.size() - 1)) {
                System.out.print(TextType.COMMA_TEXT.getText() + TextType.BLANK_TEXT.getText());
            }
        }
    }
}
