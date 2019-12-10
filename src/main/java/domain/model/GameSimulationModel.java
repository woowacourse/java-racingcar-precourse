package domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import view.PrintHandler;

public class GameSimulationModel<T extends Vehicle> {
    private static final int RANGE_OF_NUMBER = 9;
    private static final int MIN_OF_GO = 4;

    private List<T> userList;

    public GameSimulationModel(List<T> userList) {
        this.userList = userList;
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * RANGE_OF_NUMBER);
    }

    private boolean notifyGoOrStop() {
        return makeRandomNumber() >= MIN_OF_GO;
    }

    public void moveEachUsers() {
        PrintHandler<T> printHandler = new PrintHandler<>();
        for (int k = 0; k < userList.size(); k++) {
            userList.get(k).goForwardPosition(notifyGoOrStop());
            printHandler.printLocations(userList.get(k));
        }
        PrintHandler.nextLine();
    }

    public List<String> getWinner() {
        int maxPositionValue = maxPositionNumber();
        return whoIsTheSameAsMaxPosition(maxPositionValue);
    }

    private int maxPositionNumber() {
        List<Integer> positionList = new ArrayList<>();
        Iterator<T> userIterator = userList.iterator();
        while (userIterator.hasNext()) {
            positionList.add(userIterator.next().getPosition());
        }
        return Collections.max(positionList);
    }

    private List<String> whoIsTheSameAsMaxPosition(int maxPosition) {
        List<String> winners = new ArrayList<>();
        Iterator<T> userIterator = userList.iterator();
        while (userIterator.hasNext()) {
            T next = userIterator.next();
            if (next.getPosition() == maxPosition) {
                winners.add(next.getName());
            }
        }
        return winners;
    }

}
