package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class GameController {

    private Car[] carList;

    public GameController(String[] carNames) {
        carList = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            carList[i] = new Car(carNames[i]);
        }
    }

    public String[] playGame(int matchTryNumber) {
        for (int i = 0; i < matchTryNumber; i++) {
            for (Car car : carList) {
                car.moveCar();
            }
        }
        return checkWinner();
    }

    private String[] checkWinner() {
        ArrayList<String> winner = new ArrayList<>();
        int[] carWinPoint = Arrays.stream(carList).mapToInt(Car::getPosition).toArray();
        int max = Arrays.stream(carWinPoint).max().getAsInt();
        for (Car car : carList) {
            if (car.getPosition() == max) {
                winner.add(car.getName());
            }
        }
        return winner.toArray(new String[0]);
    }
}
