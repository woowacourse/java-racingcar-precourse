package racingcar.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.Car;
import racingcar.constant.Output;

public class OutputView {
    private boolean firstWinner = true;

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

    public void showWinnerCarName(ArrayList<Car> cars) {
        List<Car> collect = cars.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int max = collect.get(0).getPosition();

        for (Car car : cars) {
            if (car.getPosition() == max && !firstWinner) {
                System.out.print(Output.RESULT_COMMA_FORMAT + car.getName());
            }

            if (car.getPosition() == max && firstWinner) {
                System.out.print(Output.FINAL_WINNER + Output.RESULT_COLON_FORMAT + car.getName());
                firstWinner = false;
            }
        }
    }

    private void divisionLine() {
        System.out.println();
    }
}
