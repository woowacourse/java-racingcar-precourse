package racingcar;

import java.util.ArrayList;

public class Referee {
    public static final String FINAL_WINNER = "최종 우승자: ";
    public static final String WINNER_NAME_DELIMITER = ", ";

    public static void printWinner(Car[] gameCars) {
        int maxPosition = getMaxPosition(gameCars);
        ArrayList<String> winnerList = getWinnerList(gameCars, maxPosition);
        System.out.println(FINAL_WINNER + String.join(WINNER_NAME_DELIMITER, winnerList));
    }

    public static int getMaxPosition(Car[] gameCars) {
        int maxPostion = 0;
        for (Car car : gameCars) {
            if (car.getPosition() > maxPostion) {
                maxPostion = car.getPosition();
            }
        }
        return maxPostion;
    }

    public static ArrayList<String> getWinnerList(Car[] gameCars, int maxPosition) {
        ArrayList<String> winnerList = new ArrayList<>();
        for (Car car : gameCars) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
}