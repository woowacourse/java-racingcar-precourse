package View;

import racingcar.Car;

import java.util.List;

public class OutputView {

    private static final String PROGRESS_RESULT_MESSAGE = "실행 결과";
    private static final String WINNERS_MESSAGE = "최종 우승자: ";

    public static void printCurrentStatus(List<Car> cars) {
        cars.stream()
                .forEach(car -> System.out.println(car.getName() + " : " + car.getProgressBar()));
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        String winnersList = "";

        for (Car car : cars) {
            winnersList += car.getName() + " ";
        }
        System.out.println(WINNERS_MESSAGE + winnersList);
    }

    public static void printProgressResultMessage() {
        System.out.println();
        System.out.println(PROGRESS_RESULT_MESSAGE);
    }

}