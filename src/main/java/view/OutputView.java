package view;

import java.util.List;

import racingcar.Car;
import racingcar.Winner;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자: ";

    public static void printPlayingScreen() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResultOfEachRound(List<Car> players) {
        for (Car car : players) {
            System.out.println(car.printHowMuchEachCarMoved());
        }
        System.out.println();
    }

    public static void printWinner(Winner winner) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(winner.showWinnerName());
    }
}
