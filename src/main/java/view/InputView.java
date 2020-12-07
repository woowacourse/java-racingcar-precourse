package view;

import java.util.List;
import java.util.Scanner;

import racingcar.CarNameValidator;
import racingcar.GameRoundValidator;
import racingcar.IllegalCarNameException;
import racingcar.IllegalGameRoundException;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return validateName(scanner.nextLine());
    }

    private List<String> validateName(String name) {
        try {
            return CarNameValidator.validateCarName(name);
        } catch (IllegalCarNameException e) {
            System.out.println(e.getMessage());
            return receiveCarNames();
        }
    }

    public String receiveGameRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return validateRound(scanner.nextLine());
    }

    private String validateRound(String round) {
        try {
            GameRoundValidator.validateGameRound(round);
            return round;
        } catch (IllegalGameRoundException e) {
            System.out.println(e.getMessage());
            return receiveGameRound();
        }
    }
}
