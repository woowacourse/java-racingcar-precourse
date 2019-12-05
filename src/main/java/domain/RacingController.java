package domain;

import view.PrintHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingController {
    private static final int MIN_OF_GO = 4;

    public static void gameStart(List<Car> users, int howMany) {
        PrintHandler.gameResult();
        for (int i = 0; i < howMany; i++) {
            for (int k = 0; k < users.size(); k++) {
                users.get(k).goForwardPosition(notifyGoOrStop());
                PrintHandler.printLocations(users.get(k));
            }
            PrintHandler.nextLine();
        }
    }

    public static List<String> getWinner(List<Car> users) {
        int maxPosition = maxPositionNumber(users);
        return whoIsTheSameAsMaxPosition(users, maxPosition);
    }

    private static List<String> whoIsTheSameAsMaxPosition(List<Car> users, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPosition() == maxPosition) {
                winners.add(users.get(i).getName());
            }
        }
        return winners;
    }

    private static int maxPositionNumber(List<Car> users) {
        List<Integer> positionList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            positionList.add(users.get(i).getPosition());
        }
        return Collections.max(positionList);
    }

    private static boolean notifyGoOrStop() {
        return Computer.makeRandomNumber() >= MIN_OF_GO;
    }
}
