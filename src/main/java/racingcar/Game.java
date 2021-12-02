package racingcar;

import java.util.List;

public class Game {

    GameExecutor gameExecutor = new GameExecutor();

    public void play() {
        List<Car> carList = gameExecutor.createCars();
        int count = gameExecutor.getCount();

        doMatch(count, carList);

    }

    public void doMatch(int count, List<Car> carList) {
        for (int i = 0 ; i < count ; i++) {
            for (Car car : carList) {
                car.go();
            }

        }
    }

}
