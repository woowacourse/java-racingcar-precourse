package racingcar.View;

import racingcar.Domain.Car;
import racingcar.Domain.Cars;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final String MESSAGE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_INPUT_TRY_COUNT ="시도할 회수는 몇회인가요?";

    private static final String MOVEMENT = "-";
    public static void printInputCarName() {

        System.out.println(MESSAGE_INPUT_CAR_NAME);
    }
    public static void printExceptionMessage(IllegalArgumentException exceptionMessage) {
        System.out.println(exceptionMessage.getMessage());
    }

    public static void printInputTryCount() {
        System.out.println(MESSAGE_INPUT_TRY_COUNT);
    }

    public static void showRoundResult(Cars cars) {
        System.out.println("실행 결과");
        for(Car car : cars.getCars()){
            System.out.println(car.getName() + " : " +Stream.generate(() -> MOVEMENT).limit(car.getPosition()).collect(Collectors.joining()));
        }
        System.out.println();
    }

}
