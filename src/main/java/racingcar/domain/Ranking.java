/**
 * Ranking.java
 * 경주의 우열을 가리고 정보를 담는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ranking {
    private static final int ZERO = 0;

    private final ArrayList<Car> ranking;

    private Ranking(ArrayList<Car> ranking) {
        this.ranking = ranking;
    }

    public static Ranking from(Cars cars) {
        ArrayList<Car> ranking = new ArrayList<>();
        ranking.addAll(cars.toList());
        Collections.sort(ranking);
        Collections.reverse(ranking);
        return new Ranking(ranking);
    }

    public List<String> getWinner() {
        ArrayList<String> winners = new ArrayList<>();
        Iterator<Car> iterator = ranking.iterator();
        int topPosition = ranking.get(ZERO).getPosition();
        while (iterator.hasNext()) {
            Car currentCar = iterator.next();
            if (currentCar.getPosition() < topPosition) {
                break;
            }
            winners.add(currentCar.getName());
        }
        return winners;
    }
}
