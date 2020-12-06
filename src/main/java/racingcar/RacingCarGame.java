package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarGame {
    private final String INPUT_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)";

    private final Scanner scanner;
    private Cars cars;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        Cars cars = new Cars();
        cars.createCars(inputRacingCars());
    }

    public String inputRacingCars() {
        System.out.println(INPUT_RACING_CARS);
        return scanner.nextLine();
    }

}
