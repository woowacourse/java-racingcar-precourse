package racingcar;

import java.util.List;

public class OutputView {
    public static void printPlayingScreen() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResultOfEachRound(List<Car> players) {
        for (Car car : players) {
            System.out.println(car.printHowMuchEachCarMoved());
        }
        System.out.println();
    }

    public static void printWinner(Winner winner) {
        System.out.print("최종 우승자: ");
        System.out.println(winner.showWinnerName());
    }
}
