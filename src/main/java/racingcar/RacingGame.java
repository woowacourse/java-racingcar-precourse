package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int POINT_NUMBER = 4;
    private static final ArrayList<Car> carList = new ArrayList<>();
    private static final Player player = new Player();
    private static final Winner winner = new Winner();

    public void startGame() {
        String[] carNamesArray = player.startGame();
        this.createCarList(carNamesArray);
        System.out.println("\n실행 결과");
        while (player.remainCoin()) {
            this.playOneGame();
        }
        winner.getWinner(carList);
    }

    private void createCarList(String[] carNamesArray) {
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
    }

    private void playOneGame() {
        for (Car car : carList) {
            if (this.makeRandomNumber()) {
                car.moveForward();
            }
            car.printStatus();
        }
        System.out.println();
    }

    private boolean makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX) >= POINT_NUMBER;
    }
}
