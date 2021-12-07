package racingcar.Controller;

import racingcar.domain.Cars;

import java.util.List;

public class Controller {

    private final Cars cars;

    private Controller(Cars carGroups) {
        this.cars = carGroups;
    }

    public static Controller of(List<String> carNames) {
        return new Controller(Cars.of(carNames));
    }

    public void start(int tryNumber) {
        System.out.println("\n실행 결과");
        tryGame(tryNumber);
        printWinner();
    }

    private void tryGame(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.playRound();
            System.out.println();
        }
    }

    private void printWinner() {
        System.out.print("최종 우승자 : " + cars.getWinner());
    }
}