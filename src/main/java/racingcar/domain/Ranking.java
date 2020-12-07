/**
 * Ranking.java
 * 경주의 우열을 가리고 정보를 담는 클래스
 *
 * 수정: Kimun Kim, github.com/tributetothemoon
 */

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Ranking {
    private final PriorityQueue<Car> ranking;

    private Ranking(PriorityQueue<Car> ranking) {
        this.ranking = ranking;
    }

    public static Ranking from(Cars cars) {
        PriorityQueue<Car> ranking = new PriorityQueue<>(Collections.reverseOrder());
        cars.toList().forEach(ranking::offer);
        return new Ranking(ranking);
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int topPosition = ranking.peek().getPosition();
        while(!ranking.isEmpty() && ranking.peek().getPosition() == topPosition) {
            winners.add(ranking.poll().getName());
        }
        return winners;
    }
}
