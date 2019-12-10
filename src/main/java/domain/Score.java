/**
 * Score 클래스는 게임 점수 산출 및 우승자를 가려냅니다.
 */

package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Score {
    private RandomNumberGenerator prng;

    public Score() {
        prng = new RandomNumberGenerator();
    }

    /* 생성된 랜덤 넘버를 보고, Car 객체가 전진할지 계산*/
    public void calcScore(Car[] carArray) {
        for (Car it : carArray) {
            it.moveCar(prng.goNoGo());
        }
    }

    /* Car들을 점수 순으로 정렬 */
    public Car[] sortWinner(Car[] carArray) {
        Arrays.sort(carArray, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (o1.getPosition() < o2.getPosition())
                    return 1;
                else if (o1.getPosition() == o2.getPosition())
                    return 0;
                return -1;
            }
        });
        return carArray;
    }

    /* Car들의 점수를 보고 우승자 계산 */
    public ArrayList<Car> calcWinner(Car[] carArray) {
        Car[] sortedArray = sortWinner(carArray);

        ArrayList<Car> winner = new ArrayList<>();
        winner.add(sortedArray[0]);
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i].getPosition() == sortedArray[0].getPosition()) {
                winner.add(sortedArray[i]);
                continue;
            }
            break;
        }
        return winner;
    }
}
