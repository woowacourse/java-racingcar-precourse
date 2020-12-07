package racingcar;

import racingcar.domain.Race;
import utils.validator.CarNameValidator;
import utils.validator.MoveInputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 이 클래스는 사용자 입력을 받아 레이스를 시작시키는 클래스입니다.
 *
 * @author Byeonghwa Kim
 * @version 1.0
 */
public class Game {

    private static final String INPUT_CAR_NAMES_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_NUM_MSG = "시도할 회수는 몇회인가요?";

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        List<String> carNames = inputCarNames();
        int numOfMoves = inputRacingMoves();

        Race race = new Race(carNames, numOfMoves);
        race.start();
        System.out.println(race.getRacingResult());
    }

    private List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MSG);

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
            CarNameValidator.validateCarName(name);
        }
    }

    private int inputRacingMoves() {
        System.out.println(INPUT_MOVE_NUM_MSG);

        while (true) {
            try {
                String input = scanner.nextLine();
                int numOfMove = convertStringToIntegerAndValidate(input);
                return numOfMove;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int convertStringToIntegerAndValidate(String input) {
        return MoveInputValidator.validateNumOfMove(input);
    }
}
