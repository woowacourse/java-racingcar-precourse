package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final ArrayList<Car> carList = new ArrayList<>();
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int POINT = 4;
    private static final ArrayList<String> winnerList = new ArrayList<>();
    private static final Player player = new Player();

    public void startGame() {
        String[] carNamesArray = player.startGame();
        this.createCarList(carNamesArray);
        System.out.println("\n실행 결과");
        while (player.remainCoin()) {
            this.playOneGame();
        }
        this.getWinner();
        this.printWinner();
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

    private void getWinner() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                winnerList.clear();
                maxPosition = car.getPosition();
                winnerList.add(car.getName());
                continue;
            }
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
    }

    private void printWinner() {
        if (winnerList.size() != 1) {
            System.out.println("최종 우승자 : " + String.join(", ", winnerList));
            return;
        }
        System.out.println("최종 우승자 : " + winnerList.get(0));
    }
}
