package racingcar;

import jdk.nashorn.internal.runtime.regexp.RegExpFactory;
import racingcar.exception.RacingCarException;
import racingcar.validator.CarValidator;

import java.util.Scanner;

public class RacingCarGame {
    private final String INPUT_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)";

    private final Scanner scanner;
    private Cars cars;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        try {
            initRacingCars();
        } catch (RacingCarException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initRacingCars() {
        this.cars = new Cars();
        cars.createCars(inputRacingCars());
    }

    private String inputRacingCars() {
        System.out.println(INPUT_RACING_CARS);
        return scanner.nextLine();
    }
}
