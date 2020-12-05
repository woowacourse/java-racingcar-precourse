package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;

/**
 * 결과에 대한 클래스
 *
 * @author Daeun Lee
 */
public class Result {
    public static void showResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            StringBuffer carPosition = Position.countPosition(car);
            OutputView.printResult(car, carPosition);
        }
    }
}
