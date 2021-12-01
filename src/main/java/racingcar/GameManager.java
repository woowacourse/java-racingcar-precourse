package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Car> cars;

    public GameManager() {
        this.cars = new ArrayList<>();
    }

    public void run() {
        this.getCarList();
        int trialNum = this.getTrialNum();
        this.play(trialNum);
    }

    private void getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] carNames = Console.readLine().split(",");

        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private int getTrialNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void play(int trialNum) {
        System.out.println("실행 결과");

        for (int i = 0; i < trialNum; i++) {
            this.playTrial();
            System.out.println();
        }
    }

    private void playTrial() {
        for (Car car : cars) {
            car.play();
        }
    }
}
