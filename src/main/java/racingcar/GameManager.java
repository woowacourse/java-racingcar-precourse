package racingcar;

import utils.RandomUtils;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameManager {
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final int FIRST_ROUND = 1;
    private static final int START_INCLUSIVE_NUMBER = 0;
    private static final int END_EXCLUSIVE_NUMBER = 10;
    private static final String WINNER_ANNOUCEMENT = "최종 우승자: ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String REPLAY_OR_QUIT_INPUT_MESSAGE = "다시 시작하려면 1, 종료를 원하시면 2를 입력해주세요.";
    private static final String REPLAY_OR_QUIT_INPUT_ERROR_MESSAGE = "[ERROR] 1 혹은 2만 입력 가능합니다.";

    private void moveCars(List<Car> cars) {
        cars.forEach(car -> {
                    int randomNumber = RandomUtils.nextInt(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER);
                    car.changePosition(randomNumber);
                });
    }

    private String getCarPositionInformation(Car car) {
        return car.getName() + " : " + car.getCarPositionStatus();
    }

    private void announceCurrentStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(getCarPositionInformation(car)));
        System.out.println();
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private String getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private void announceWinners(List<Car> cars) {
        String winners = getWinners(cars);
        System.out.println(WINNER_ANNOUCEMENT + winners);
    }

    public void startRacing(List<Car> cars, int numberOfRounds) {
        System.out.println(GAME_RESULT_MESSAGE);
        for (int round = FIRST_ROUND; round <= numberOfRounds; round ++) {
            moveCars(cars);
            announceCurrentStatus(cars);
        }
        announceWinners(cars);
    }

    private void checkReplayOrQuitInputValidity(String replayOrQuitInput) throws IllegalArgumentException {
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
                checkReplayOrQuitInputValidity(replayOrQuitInput);
                isValidReplayOrQuitInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
