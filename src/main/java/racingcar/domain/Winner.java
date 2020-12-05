package racingcar.domain;

import racingcar.type.ValueType;
import racingcar.view.OutputView;

import java.util.ArrayList;

/**
 * 우승자에 대한 클래스
 *
 * @author Daeun Lee
 */
public class Winner {
    private static int maxPosition;
    private static ArrayList<String> winner = new ArrayList<>();

    public static void showWinner(ArrayList<Car> cars) {
        ArrayList<Integer> carPositions = Position.addPosition(cars);
        maxPosition = Position.calculateMaxPosition(carPositions);

        checkWinner(cars);

        if (winner.size() == ValueType.ZERO.getValue()) {
            isNoWinner();
        }

        if (winner.size() != ValueType.ZERO.getValue()) {
            isWinner();
        }
    }

    public static void checkWinner(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }
    }

    public static void isNoWinner() {
        OutputView.printNoWinner();
    }

    public static void isWinner() {
        OutputView.printWinner(winner);
    }
}
