package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private int attempt;

    public void play() {
        setUp();
        startRacing(attempt);
        finish();
    }

    private void setUp() {
        for (String carName : InputView.inputCarList()) {
            carList.add(new Car(carName));
        }
        attempt = InputView.inputAttempt();
    }

    private void startRacing(int attempt) {
        System.out.println(RacingCarConstant.RESULT_MESSAGE);

        for (int i = 0; i < attempt; i++) {
            for (Car car : carList) {
                car.move();
                car.showPosition();
            }
            System.out.println();
        }
    }

    private void finish() {
        List<String> winnerList = findWinnerList();
        showWinnerList(winnerList);
    }

    private void showWinnerList(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(RacingCarConstant.DELIMITER + " ", winnerList));
    }

    private List<String> findWinnerList() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
