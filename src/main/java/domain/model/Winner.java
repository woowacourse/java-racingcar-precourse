package domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import domain.model.Vehicle;

public class Winner<T extends Vehicle> {
    private List<T> user;

    public Winner(List<T> user) {
        this.user = user;
    }

    public List<String> getWinner(){
        int maxPositionValue = maxPositionNumber(user);
        return whoIsTheSameAsMaxPosition(user, maxPositionValue);
    }

    private int maxPositionNumber(List<T> users) {
        List<Integer> positionList = new ArrayList<>();
        Iterator<T> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            positionList.add(userIterator.next().getPosition());
        }
        return Collections.max(positionList);
    }

    private List<String> whoIsTheSameAsMaxPosition(List<T> users, int maxPosition) {
        List<String> winners = new ArrayList<>();
        Iterator<T> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            T next = userIterator.next();
            if (next.getPosition() == maxPosition) {
                winners.add(next.getName());
            }
        }
        return winners;
    }


}
