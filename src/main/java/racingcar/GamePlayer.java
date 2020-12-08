package racingcar;

import java.util.Scanner;

public class GamePlayer {
    final static String raceResult = "실행 결과";

    public static void playGame(Scanner scanner) {
        String[] carsList = UserInput.makeCarsList(scanner);
        Car[] carInstances = CarMaker.makeCarInstances(carsList);
        int playTime = UserInput.makePlayTime(scanner);
        System.out.println();
        System.out.println(raceResult);
        for (int i = 0; i < playTime; i++) {
            Racing.playRace(carInstances);
        }
        WinnerSelection.selectWinner(carInstances);
    }
}
