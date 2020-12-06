package racingcar;

import jdk.nashorn.internal.runtime.regexp.RegExpFactory;
import racingcar.exception.RacingCarException;
import racingcar.validator.CarValidator;

import java.util.Scanner;

public class RacingCarGame {
    private final String INPUT_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)";
    private final String INPUT_RACING_ROUND = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;
    private Cars cars;
    private Round round;


    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        try {
            initialize();
        } catch (RacingCarException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initialize() {
        initRacingCars();
        initRacingRound();
    }

    private void initRacingCars() {
        this.cars = new Cars(inputRacingCars());
    }

    private String inputRacingCars() {
        System.out.println(INPUT_RACING_CARS);
        return scanner.nextLine();
    }

    private void initRacingRound() {
        this.round = new Round(inputRacingRound());
    }

    private String inputRacingRound() {
        System.out.println(INPUT_RACING_ROUND);
        return scanner.nextLine();
    }
}
