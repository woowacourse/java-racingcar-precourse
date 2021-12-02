package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private static List<Car> cars = new ArrayList<>();
    private static int trialNumber;

    public static void play() {
        setGame();
        System.out.println(SystemMessage.RESULT_MESSAGE);
        for (int i = 1; i <= trialNumber; i++) {
            startRound();
        }
        Board.showResult(cars);
    }

    private static void setGame() {
        setCars();
        trialNumber = setTrialNumber();
    }

    private static void setCars() {
        System.out.println(SystemMessage.ASK_NAMES_MESSAGE);
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidateInput(input));
        cars = GameUtil.parseStringToList(new ArrayList<>(), input);
    }

    private static int setTrialNumber() {
        System.out.println(SystemMessage.ASK_NUMBER_MESSAGE);
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidateNumber(input));
        return Integer.parseInt(input);
    }

    private static void startRound() {
        for (Car car : cars) {
            GameUtil.tryMove(car);
        }
        Board.showStatus(cars);
    }
}
