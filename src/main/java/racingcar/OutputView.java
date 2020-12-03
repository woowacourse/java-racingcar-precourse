package racingcar;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ROUND_NUMBER_QUESTION = "시도할 회수는 몇회인가요?";
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자: ";

    public void printCarNameQuestion() {
        System.out.println(CAR_NAME_QUESTION);
    }
    public void printRoundNumberQuestion() {
        System.out.println(ROUND_NUMBER_QUESTION);
    }

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
