package racingcar;

import java.util.ArrayList;

public class WinnerSelection {
    final static String winnerMessage = "최종 우승자: ";

    public static void selectWinner(Car[] carInstances) {
        ArrayList<String> winnerCars = new ArrayList<String>();
        for (int i = 0; i < carInstances.length; i++) {
            if (carInstances[i].getPosition() == Racing.maxPosition) {
                winnerCars.add(carInstances[i].getName());
            }
        }
        String winner = String.join(", ", winnerCars);
        System.out.println(winnerMessage + winner);
    }
}
