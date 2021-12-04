package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private static final int firstRound = 1;
    private static List<Car> cars = new ArrayList<>();
    private static int roundNumber;

    public static void play() {
        setGame();
        System.out.println(SystemMessage.RESULT_MESSAGE);
        for (int i = firstRound; i <= roundNumber; i++) {
            startRound();
        }
        Board.showResult(cars);
    }

    private static void setGame() {
        setCars();
        setRoundNumber();
    }

    private static void setCars() {
        System.out.println(SystemMessage.ASK_NAMES_MESSAGE);
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidateInput(input));
        cars = StringParser.parseStringToList(new ArrayList<>(), input);
    }

    private static void setRoundNumber() {
        System.out.println(SystemMessage.ASK_NUMBER_MESSAGE);
        String input;
        do {
            input = Console.readLine();
        } while (!Validator.isValidateNumber(input));
        roundNumber = Integer.parseInt(input);
    }

    private static void startRound() {
        for (Car car : cars) {
            Referee.tryMove(car);
        }
        Board.showStatus(cars);
    }
}
