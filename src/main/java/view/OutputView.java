package view;

import domain.Car;
import util.StringUtil;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_WINNER_MENT = "가 최종 우승했습니다.";
    private static final String OUTPUT_PROCESS_MENT = "실행결과";
    private static final String COLON = " : ";
    private static final String PATH = "-";

    public static void printResult() {
        System.out.println(OUTPUT_PROCESS_MENT);
    }

    public static void printProcess(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + COLON);
            System.out.println(StringUtil.repeatString(PATH, car.getPosition()));
        });
        System.out.println();
    }

    public static void printWinner(String winnersString) {
        System.out.println(winnersString + OUTPUT_WINNER_MENT);
    }
}
