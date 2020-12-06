package racingcar;

import java.util.Scanner;
import utils.ValidatorUtils;

public class PlayerResponse {

    private static final String ASKING_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ASKING_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NAMES_DELIMITER = ",";
    private final Scanner scanner;

    public PlayerResponse(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getCarNames() {
        String[] carNames;
        while (true) {
            try {
                System.out.println(ASKING_NAMES_MESSAGE);
                carNames = responseOfCarNames();
                ValidatorUtils.checkUnderFiveLetters(carNames);
                return carNames;
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    public int getHowManyMoves() {
        while (true) {
            try {
                System.out.println(ASKING_MOVES_MESSAGE);
                String movesBeforeCheck = responseOfMoves();
                ValidatorUtils.checkIsNumber(movesBeforeCheck);
                return Integer.parseInt(movesBeforeCheck);
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage());
            }
        }
    }

    private String[] responseOfCarNames() {
        String[] carNames = scanner.nextLine().split(NAMES_DELIMITER);
        return deleteWhiteSpace(carNames);
    }

    private String[] deleteWhiteSpace(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    private String responseOfMoves() {
        return scanner.nextLine().trim();
    }

}