package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.NumberToDashConverter;

import java.util.List;

import static racingcar.constant.Constants.*;

public class OutputView {

    public void showGameResult() {
        System.out.println();
        System.out.println(GAME_RESULT);
    }

    public void showEachRoundResult(Cars cars) {

        for (Car car : cars.getCarList()) {
            System.out.println(car.getName() + " : " + NumberToDashConverter.convert(car.getPosition()));
        }

        System.out.println();
    }

    public void showWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WINNERS);
        int lastCarIndex = winners.size() - 1;

        for (int index = MIN_INDEX_VALUE; index < lastCarIndex; index++) {
            stringBuilder.append(winners.get(index).getName() + ", ");
        }

        stringBuilder.append(winners.get(lastCarIndex).getName());
        System.out.println(stringBuilder.toString());
    }
}
