package racingcar.game;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.UserInputUtil.*;

public class RacingGame {

    public void startGame() {
        List<Car> carList = getCarList();

        int count = getAttemptNumberInput();

        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            progressGame(carList);
        }

        printWinners(carList);
    }

    private List<Car> getCarList() {
        String[] carNames = getCarNameInput();

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private String[] getCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        while (true) {
            try {
                String[] carNames = getCarNames();

                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getAttemptNumberInput() {
        System.out.println("시도할 회수는 몇회인가요?");

        while (true) {
            try {
                int count = getAttemptNumber();

                return count;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void progressGame(List<Car> carList) {
        for (Car car : carList) {
            car.progress();
            car.printProgress();
        }

        System.out.println();
    }

    private void printWinners(List<Car> carList) {
        List<String> winners = getWinnerNames(carList);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> getWinnerNames(List<Car> carList) {
        List<String> winners = new ArrayList<>();

        int maxPosition = getMaxPosition(carList);

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;

        for (Car car : carList) {
            int position = car.getPosition();

            if (position >= maxPosition) {
                maxPosition = position;
            }
        }

        return maxPosition;
    }
}
