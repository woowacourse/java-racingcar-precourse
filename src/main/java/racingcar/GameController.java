package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class GameController {

    private Car[] carList;

    public GameController(String[] carNames) {
        carList = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            carList[i] = new Car(carNames[i]);
        }
    }

    public void playGame(int matchTryNumber) {
        for (int i = 0; i < matchTryNumber; i++) {
            for (Car car : carList) {
                car.moveCar();
            }
            System.out.println("");
        }
        String[] winner = checkWinner();
        winnerPrint(winner);
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

    private void winnerPrint(String[] winner) {
        String winners = Arrays.toString(winner);
        System.out.println("최종 우승자: " + winners.substring(1,winners.length()-1));
    }
}
