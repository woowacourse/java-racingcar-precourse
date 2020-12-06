package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String COLON = " : ";
    private static final String SCORE = "_";
    private OutputView() {
    }

    public static void printRoundResult(List<Car> carList) {
        for (int idx = 0; idx < carList.size(); idx++) {
            printScore(carList.get(idx));
        }
    }

    private static void printScore(Car car) {
        System.out.print(car.getName() + COLON);
        System.out.println(new String(new char[car.getPosition()]).replace("\0",SCORE));
    }

}
