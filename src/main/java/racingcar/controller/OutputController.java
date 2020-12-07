package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputController {
    private static final String RUN_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자: ";

    public void printPlayGameMessage() {
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void printWinner(Cars cars) {
        String winner = String.join(", ", cars.getWinnerName());
        System.out.println(WINNER_MESSAGE + winner);
    }
}