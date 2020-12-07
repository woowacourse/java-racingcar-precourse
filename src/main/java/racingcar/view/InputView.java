package racingcar.view;

import racingcar.exception.RoundIllegalArgumentException;

import java.util.Scanner;

public class InputView {
    private final String INPUT_RACING_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)";
    private final String INPUT_RACING_ROUND = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputRacingCars() {
        System.out.println(INPUT_RACING_CARS);
        return scanner.nextLine();
    }

    public int inputRacingRound() {
        System.out.println(INPUT_RACING_ROUND);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new RoundIllegalArgumentException();
        }
    }

}
