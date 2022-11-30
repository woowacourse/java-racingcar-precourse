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

    }

