package racingcar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import constant.SystemMessage;

public class RacingGame {
    private Player[] players;
    private int turn;
    private Scanner scanner;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final char START_INCLUSIVE = 0;
    private static final char END_INCLUSIVE = 9;
    private static final int MIN_TURN = 1;
    private static final String CAR_NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE = SystemMessage.ERROR_MESSAGE + " 자동차 이름의 길이는 "
            + MAX_CAR_NAME_LENGTH + "이하여야 합니다.";
    private static final String TURN_MISMATCH_EXCEPTION_MESSAGE = SystemMessage.ERROR_MESSAGE + " 시도 횟수는 숫자여야 합니다.";
    private static final String TURN_VALUE_LOWER_ONE_EXCEPTION_MESSAGE = SystemMessage.ERROR_MESSAGE
            + " 시도 횟수는 1 이상의 정수여야합니다.";

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void playGame() {
        inputCarName();
        inputTurn();

        System.out.println("\n" + SystemMessage.RUN_RESULT + "\n");
        for (int i = 0; i < turn; i++) {
            startRacing();
            printProgress();
        }

        printChampion();
    }

    private void startRacing() {
        for (int i = 0; i < players.length; i++) {
            players[i].racing();
        }
    }

    private void printProgress() {
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getCarName() + " " + SystemMessage.SEPARATOR_COLON + " ");

            int position = players[i].getCarPosition();
            for (int j = 0; j < position; j++) {
                System.out.print(CAR_NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printChampion() {
        System.out.print(SystemMessage.CHAMPION + " ");
        List<String> championList = getChampionList();
        System.out.println(championList.get(0));
        for (int i = 1; i < championList.size(); i++) {
            System.out.print(SystemMessage.SEPARATOR_COMMA + " " + championList.get(i));
        }
    }

    private List<String> getChampionList() {
        // 가장 먼 위치가 몇인지 값을 구함.
        int position = players[0].getCarPosition();
        for (int i = 1; i < players.length; i++) {
            position = Math.max(position, players[i].getCarPosition());
        }

        // 가장 먼 위치에 해당하는 차의 이름을 리스트에 담음.
        List<String> championList = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getCarPosition() == position) {
                championList.add(players[i].getCarName());
            }
        }
        return championList;
    }

    private void inputCarName() {
        System.out.println(SystemMessage.INPUT_CAR_NAME_MESSAGE);
        String[] input = scanner.next().split(",");
        if (!isValidCarNameLength(input)) {
            throw new IllegalAccessError(CAR_NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE);
        }

        players = new Player[input.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(input[i]);
        }
    }

    private boolean isValidCarNameLength(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() > MAX_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    private void inputTurn() {
        System.out.println(SystemMessage.INPUT_TURN_MESSAGE);
        String input = scanner.next();
        if (!isInteger(input)) {
            throw new InputMismatchException(TURN_MISMATCH_EXCEPTION_MESSAGE);
        }

        if (isValueLowerOne(Integer.parseInt(input))) {
            throw new IllegalArgumentException(TURN_VALUE_LOWER_ONE_EXCEPTION_MESSAGE);
        }

        turn = Integer.parseInt(input);
    }

    private boolean isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= START_INCLUSIVE && input.charAt(i) <= END_INCLUSIVE)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueLowerOne(int input) {
        if (input < MIN_TURN) {
            return true;
        }
        return false;
    }
}
