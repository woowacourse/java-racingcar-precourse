package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingSystem {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private InputSystem inputSystem = new InputSystem();
    private List<Car> cars = new ArrayList<>();
    private Winners winners = new Winners();
    private int cnt = 0;

    public RacingSystem() {
    }

    public Winners getWinners() {
        return winners;
    }

    public void input() {
        inputSystem.inputCarName(cars);
        cnt = inputSystem.inputTryCnt();
    }

    public void racingStart() {
        while (winners.getWinnersCnt() == 0) {
            for (Car car : cars) {
                int random = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
                car.go(random);
                System.out.println(car.getCarStatus());
                getWinner(car.getName(), car.getPosition());
            }
            System.out.println();
        }
    }

    public void printWinners() {
        System.out.println("최종 우승자 : " + winners.toString());
    }

    private void getWinner(String name, int position) {
        if (position == cnt) {
            winners.addWinner(name);
        }
    }
}
