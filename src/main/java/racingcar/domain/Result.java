package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;

/**
 * 결과에 대한 클래스
 *
 * @author Daeun Lee
 */
public class Result {
    /**
     * @param cars 자동차를 원소로 가진 리스트
     */
    public static void showResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            StringBuffer carPosition = Position.drawPosition(car);
            OutputView.printResult(car, carPosition);
        }
    }
}
