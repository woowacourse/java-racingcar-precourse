package racingcar;

import java.util.Scanner;

public class GamePlayer {
    public static void playGame (Scanner scanner) {
        String[] carsList = UserInput.makeCarsList(scanner);
        Car[] carInstances = CarMaker.makeCarInstances(carsList);
        int playTime = UserInput.makePlayTime(scanner);
        for (int i = 0; i < playTime; i++) {
            Racing.playRace(carInstances);
        }
        WinnerSelection.selectWinner(carInstances); 
    }
}
