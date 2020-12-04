package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        List<String> carNames = inputCarNames();
        int numOfMoves = inputRacingMoves();
    }

    private List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        while (true) {
            try {
                String[] input = scanner.nextLine().split(",");
                validateCarNames(input);
                return Arrays.asList(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateCarNames(String[] carNames) throws RuntimeException {
        for (String name : carNames) {
            if (name.length() >= 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
            }
            if (name.equals(" ") || name.equals("")) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름으로 빈 칸은 안됩니다.");
            }
        }
    }

    private int inputRacingMoves() {
        System.out.println("시도할 회수는 몇회인가요?");

        while (true) {
            try {
                String input = scanner.nextLine();
                int numOfMoves = Integer.parseInt(input);
                validatePositiveNumber(numOfMoves);
                return numOfMoves;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePositiveNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 양수여야 합니다.");
        }
    }
}
