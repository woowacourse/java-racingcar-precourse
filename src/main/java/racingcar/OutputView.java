package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ROUND_NUMBER_QUESTION = "시도할 회수는 몇회인가요?";
    private final String RESULT_MESSAGE = "실행 결과";
    private final String WINNER_MESSAGE = "최종 우승자: ";

    public void printCarNameQuestion() {
        System.out.println(CAR_NAME_QUESTION);
    }
    public void printRunCountQuestion() {
        System.out.println(ROUND_NUMBER_QUESTION);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(ScoreBoard scoreBoard) {
        List<Car> cars = scoreBoard.getResult();
        cars.forEach(this::printResult);
        System.out.println();
    }

    private void printResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(ScoreBoard scoreBoard) {
        System.out.println(WINNER_MESSAGE + getWinnerNames(scoreBoard));
    }

    private String getWinnerNames(ScoreBoard scoreBoard){
        return scoreBoard.getWinners()
                         .stream()
                         .map(Car::getName)
                         .collect(Collectors.joining(", "));
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
