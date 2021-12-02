package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {
    private static final ArrayList<Car> carList = new ArrayList<>();
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int POINT = 4;
    private final Player player;

    public RacingGame() {
        this.player = new Player();
    }

    public void startGame() {
        String[] carNamesArray = player.startGame();
        this.createCarList(carNamesArray);
        System.out.println("실행 결과");
        while (player.remainCoin()) {
            this.playOneGame();
        }
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
        return Randoms.pickNumberInRange(MIN, MAX) >= POINT;
    }
}
