package racingcar;

import java.util.Scanner;
import utils.ScriptUtils;

public class Game {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int UNSET_INT = -1;
    private static final String DELIMITER = ",";
    private static final String UNSET_STRING = "";

    private static String[] carNames;
    private static Car[] cars;
    private static int tryCnt = UNSET_INT;

    private Game() {
    }

    private static void enterName(Scanner scanner) {
        String input = scanner.nextLine();
        carNames = input.split(DELIMITER);
        try {
            checkName();
        } catch (IllegalArgumentException e) {
            System.out.println(ScriptUtils.ERROR_ILLEGAL_NAME);
            carNames = null;
        }
    }

    private static void checkName() {
        for (String carName : carNames) {
            if (carName.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void enterTryCnt(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            tryCnt = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ScriptUtils.ERROR_ILLEGAL_TRY_CNT);
            tryCnt = UNSET_INT;
        }
    }

    public static void setGame(Scanner scanner) {
        System.out.println(ScriptUtils.ASK_CAR_NAMES);
        while (carNames == null) {
            enterName(scanner);
        }
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        System.out.println(ScriptUtils.ASK_TRY_COUNT);
        while (tryCnt <= UNSET_INT) {
            enterTryCnt(scanner);
        }
    }

    public static void playGame() {
        System.out.println(ScriptUtils.INFORM_RESULT);
        for (int i = 0; i < Game.tryCnt; i++) {
            for (Car car : cars) {
                car.moveCar();
            }
            System.out.println();
        }
    }

    public static void finishGame() {
        int max = UNSET_INT;
        String winners = UNSET_STRING;
        for (Car car : cars) {
            int carPosition = car.getPosition();
            if (max > carPosition) {
                continue;
            }
            winners = car.nominateCar(max, winners);
            max = carPosition;
        }
        System.out.println(ScriptUtils.INFORM_WINNER + winners);
    }
}
