package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    private static final String MESSAGE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_INPUT_TRY = "시도할 회수는 몇회인가요?";
    private static final String MOVE_MARK = "-";
    private static final String JOIN_NAME_AND_POSITION = " : ";

    private static final String WINNER_DELIMITER = ",";
    private static final String MESSAGE_WINNER_PREFIX = "최종 우승자 : ";
    private static final String MESSAGE_WINNER_SUFFIX = "";

    public void printInputCarName() {
        System.out.println(MESSAGE_INPUT_CAR_NAME);
    }

    public void printExceptionMessage(IllegalArgumentException exceptionMessage) {
        System.out.println(exceptionMessage.getMessage());
    }

    public void printInputTry() {
        System.out.println(MESSAGE_INPUT_TRY);
    }

    public void printBlank() {
        System.out.println();
    }

    public void printResult(Cars cars) {
        System.out.println("실행 결과");
        for(Car car : cars.getCars()){
            System.out.println(car.getName() + JOIN_NAME_AND_POSITION + convertMoveMark(car.getPosition()));
        }
        printBlank();
    }

    private String convertMoveMark(int position) {
        return Stream.generate(() -> MOVE_MARK).limit(position).collect(Collectors.joining());
    }

    public void printWinner(Winner winner) {
        String message = winner.getWinner().stream()
                .collect(Collectors.joining(WINNER_DELIMITER, MESSAGE_WINNER_PREFIX, MESSAGE_WINNER_SUFFIX));
        System.out.println(message);
    }
}
