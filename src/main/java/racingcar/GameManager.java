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

    // devide exception cases into smaller pieces of methods
    private void validateReplayOrQuitInput(String replayOrQuitInput) throws IllegalArgumentException {
        int replayOrQuit;
        try {
            replayOrQuit = Integer.parseInt(replayOrQuitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
        }
        if (replayOrQuit != 1 && replayOrQuit != 2) {
            throw new IllegalArgumentException(REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE);
        }
        if (replayOrQuit == 1) {
            Application.main(null); // REPLAY
        }
        // QUIT
    }

    public void replayOrQuit(Scanner scanner) {
        boolean isValidReplayOrQuitInput = false;
        while (!isValidReplayOrQuitInput) {
            try {
                System.out.println(REPLAY_OR_QUIT_INPUT_MESSAGE);
                String replayOrQuitInput = scanner.nextLine();
                validateReplayOrQuitInput(replayOrQuitInput);
                isValidReplayOrQuitInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
