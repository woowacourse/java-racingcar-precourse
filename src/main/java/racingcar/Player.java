package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class Player {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INSERT_COIN_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ERROR = "[ERROR]";
    private static final Validator validator = new Validator();
    private static int gameCoin;
    private static String carNames;
    private static String[] carNamesArray;

    public String[] startGame() {
        this.validateInputCarNames();
        this.validateInsertCoin();
        return carNamesArray;
    }

    public boolean remainCoin() {
        return gameCoin-- != 0;
    }

    private void validateInputCarNames() {
        while (true) {
            this.inputCarNames();
            try {
                validator.validateCarNamesLength(carNamesArray);
                validator.validateCarNamesDuplicate(carNamesArray);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR + exception.getMessage());
            }
        }
    }

    private void validateInsertCoin() {
        while (true) {
            String coin = this.insertCoin();
            try {
                gameCoin = validator.validateOnlyInteger(coin);
                validator.validateMoreThanOne(gameCoin);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR + exception.getMessage());
            }
        }
    }

    private void inputCarNames() {
        System.out.println(INPUT_CAR_MESSAGE);
        carNames = Console.readLine();
        carNamesArray = carNames.split(",");
    }

    private String insertCoin() {
        System.out.println(INSERT_COIN_MESSAGE);
        String coin = Console.readLine();
        return coin;
    }
}
