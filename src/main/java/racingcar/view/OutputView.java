package racingcar.view;

import racingcar.RacingCarGame;

import java.util.List;

public class OutputView {
    private static final String MESSAGE_WINNING_CARS = "최종 우승자 : ";

    public void printMovingResult(RacingCarGame racingCarGame) {
        List<String> movingResult = racingCarGame.getMovingResult();
        movingResult.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    public void printRacingResult(RacingCarGame racingCarGame) {
        String racingResult = String.join(",", racingCarGame.getWinningCars());

        System.out.println(MESSAGE_WINNING_CARS + racingResult);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    }

