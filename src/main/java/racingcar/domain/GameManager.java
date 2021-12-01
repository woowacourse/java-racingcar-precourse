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

        int trialNum = this.getTrialNum();
        this.play(trialNum);

        List<String> winners = this.getWinners();
        printWinners(winners);
    }

    private void getCarList() {
        for (String carName : User.getCarNamesInput()) {
            this.cars.add(new Car(carName));
        }
    }

    private int getTrialNum() {
        return User.getTrialNumInput();
    }

    private void play(int trialNum) {
        System.out.println("실행 결과");

        for (int i = 0; i < trialNum; i++) {
            this.playOnce();
            System.out.println();
        }
    }

    private void playOnce() {
        for (Car car : cars) {
            car.play();
        }
    }

    private List<String> getWinners() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            int curPosition = car.getPosition();
            if (curPosition < maxPosition) {
                continue;
            }
            if (curPosition > maxPosition) {
                winners.clear();
                maxPosition = curPosition;
            }
            winners.add(car.getName());
        }

        return winners;
    }

    private void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
            return;
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
