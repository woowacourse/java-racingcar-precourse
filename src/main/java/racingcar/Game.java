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

            printCurrentState(carList);
        }
    }

    public void printCurrentState(List<Car> carList) {
        String result = "";
        for (Car car : carList) {
            result += car.getName() + " : " + convertInt2Hyphen(car.getPosition()) + "\n";
        }
        System.out.println(result);
    }

    private String convertInt2Hyphen(int goCount) {
        String result = "";

        for (int i = 0 ; i < goCount ; i++) {
            result += "-";
        }

        return result;
    }
}
