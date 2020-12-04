package racingcar;

import java.util.Scanner;

public class GameManager {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final int FIRST_ROUND = 1;
    private static final String WINNER_ANNOUCEMENT = "최종 우승자: ";
    private static final String REPLAY_OR_QUIT_INPUT_MESSAGE = "다시 시작하려면 1, 종료를 원하시면 2를 입력해주세요.";
    private static final String REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE = "[ERROR] 1 혹은 2만 입력 가능합니다.";

    private void announceCurrentStatus(Cars cars) {
        cars.getCarPositionAnnouncement();
        System.out.println();
    }

    private void announceWinners(Cars cars) {
        System.out.println(WINNER_ANNOUCEMENT + cars.getWinners());
    }

    public void startRacing(Cars cars, int numberOfRounds) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (int round = FIRST_ROUND; round <= numberOfRounds; round ++) {
            cars.moveCars();
            announceCurrentStatus(cars);
        }
        announceWinners(cars);
    }

    private void validateInteger(String replayOrQuitInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(replayOrQuitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateOneOrTwo (String replayOrQuitInput) throws IllegalArgumentException {
        int replayOrQuit = Integer.parseInt(replayOrQuitInput);
        if (replayOrQuit != 1 && replayOrQuit != 2) {
            throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
        }
    }

    private int tryToGetReplayOrQuitInput(Scanner scanner) {
        System.out.println(REPLAY_OR_QUIT_INPUT_MESSAGE);
        String replayOrQuitInput = scanner.nextLine();
        try {
            validateInteger(replayOrQuitInput);
            validateOneOrTwo(replayOrQuitInput);
            return Integer.parseInt(replayOrQuitInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private int getReplayOrQuitInput(Scanner scanner) {
        int replayOrQuitInput;
        do {
            replayOrQuitInput = tryToGetReplayOrQuitInput(scanner);
        } while (replayOrQuitInput == 0);
        return replayOrQuitInput;
    }

    public void replayOrQuit(Scanner scanner) {
        int replayOrQuitInput = getReplayOrQuitInput(scanner);
        if (replayOrQuitInput == 1) {
            Application.main(null); // REPLAY
        }
        // OTHERWISE QUIT
    }
}
