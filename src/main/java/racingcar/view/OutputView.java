package racingcar.view;

import java.util.ArrayList;

import racingcar.Car;
import racingcar.constant.Output;

public class OutputView {
    public void showCurrentPosition(ArrayList<Car> cars) {
        System.out.println(Output.RESULT_START_MESSAGE);
        for (Car car : cars) {
            System.out.println(car.getName() + Output.RESULT_COLON_FORMAT + showMoveByPosition(car.getPosition()));
        }
        divisionLine();
    }

    private String showMoveByPosition(int position) {
        StringBuilder move = new StringBuilder();
        for (int i = 0; i < position; i++) {
            move.append("-");
        }
        return move.toString();
    }

    private void divisionLine() {
        System.out.println();
    }
}
