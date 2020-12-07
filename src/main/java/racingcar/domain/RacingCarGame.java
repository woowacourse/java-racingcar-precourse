package racingcar.domain;

import racingcar.exception.RacingCarException;

import java.util.Scanner;

public class RacingCarGame {
    private final String INPUT_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)";
    private final String INPUT_RACING_ROUND = "시도할 회수는 몇회인가요?";
    private final String EXECUTION_RESULT = "\n실행 결과";

    private final Scanner scanner;
    private Cars cars;
    private Round round;

    public RacingCarGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        try {
            initialize();
            startRacing();
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

    private void startRacing() {
        System.out.println(EXECUTION_RESULT);
        for (int currentRound = 0; currentRound < round.getRound(); currentRound++) {
            cars.racing();
        }
    }
}
