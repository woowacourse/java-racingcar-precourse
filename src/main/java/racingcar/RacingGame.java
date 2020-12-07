package racingcar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import constant.SystemMessage;
import exception.CarNameLengthExcessException;
import exception.ValueLowerOneException;

public class RacingGame {
    private Player[] players;
    private int turn;
    private Scanner scanner;
    private static final int MAX_CAR_NAME_LENGTH = 5;
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
            String result = "";
            for (int j = 0; j < position; j++) {
                result += SystemMessage.DISTANCE;
            }
            System.out.println(result);
        }
        System.out.println();
    }

    private void printChampion() {
        System.out.print(SystemMessage.CHAMPION + " ");
        List<String> championList = getChampionList();
        System.out.print(championList.get(0));
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
        while (true) {
            System.out.println(SystemMessage.INPUT_CAR_NAME_MESSAGE);
            try {
                String[] input = isValidCarName(scanner.next().split(","));
                players = new Player[input.length];

                for (int i = 0; i < players.length; i++) {
                    players[i] = new Player(input[i]);
                }
                break;
            } catch (CarNameLengthExcessException e) {
                System.out.println(CAR_NAME_LENGTH_EXCESS_EXCEPTION_MESSAGE);
            }
        }
    }

    private String[] isValidCarName(String[] input) {
        if (!isValidCarNameLength(input)) {
            throw new CarNameLengthExcessException();
        }
        return input;
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
        while (true) {
            System.out.println(SystemMessage.INPUT_TURN_MESSAGE);
            try {
                turn = isValidTurn(scanner.nextInt());
                break;
            } catch (InputMismatchException e) { // 정수가 아닐 경우.
                System.out.println(TURN_MISMATCH_EXCEPTION_MESSAGE);
            } catch (ValueLowerOneException e) {
                System.out.println(TURN_VALUE_LOWER_ONE_EXCEPTION_MESSAGE);
            }
        }
    }

    private int isValidTurn(int input) {
        if (isValueLowerOne(input)) {
            throw new ValueLowerOneException();
        }
        return input;
    }

    private boolean isValueLowerOne(int input) {
        if (input < MIN_TURN) {
            return true;
        }
        return false;
    }
}
