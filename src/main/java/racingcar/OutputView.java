package racingcar;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자: ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(ScoreBoard scoreBoard) {
        ArrayList<Car> cars = scoreBoard.getResult();
        cars.forEach(this::printResult);
    }

    private void printResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(ScoreBoard scoreBoard) {
        System.out.println(WINNER_MESSAGE + getWinnerNames(scoreBoard));
        System.out.println();
    }

    private String getWinnerNames(ScoreBoard scoreBoard){
        Stream<String> winners = scoreBoard.getWinners().stream().map(Car::getName);
        return winners.collect(Collectors.joining(", "));
    }
}
