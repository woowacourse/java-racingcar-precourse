package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final List<Car> cars;

    public GameManager() {
        this.cars = new ArrayList<>();
    }

    public void run() {
        this.getCarList();
        int trialNum = User.getTrialNumInput();
        this.play(trialNum);
        this.printWinners();
    }

    private void getCarList() {
        for (String carName : User.getCarNamesInput()) {
            this.cars.add(new Car(carName));
        }
    }

    private void play(int trialNum) {
        System.out.println("실행 결과");

        for (int i = 0; i < trialNum; i++) {
            this.playOnce();
        }
    }

    private void playOnce() {
        for (Car car : cars) {
            car.play();
        }
        System.out.println();
    }

    private void printWinners() {
        List<String> winners = this.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = this.getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : this.cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }
}
