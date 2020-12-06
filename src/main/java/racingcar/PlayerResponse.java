package racingcar;

import java.util.Scanner;
import utils.ValidatorUtils;

public class PlayerResponse {


    private Scanner scanner;

    public PlayerResponse(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getHowManyMoves() {
        while (true) {
            try {
                String movesBeforeCheck = askMoves();
                ValidatorUtils.checkIsNumber(movesBeforeCheck);
                return Integer.parseInt(movesBeforeCheck);
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    private String askMoves() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine().trim();
    }

    public String[] getCarNames() {
        String[] carNames;
        while (true) {
            try {
                carNames = askCarNames();
                ValidatorUtils.checkUnderFiveLetters(carNames);
                return carNames;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }


    private String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }
}
