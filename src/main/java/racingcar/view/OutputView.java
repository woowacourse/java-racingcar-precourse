package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void racePrint(List<Car> carList){
        carList.stream().forEach(c -> c.showInfo());
        System.out.println();
    }
}
