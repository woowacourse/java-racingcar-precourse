package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Score {

    /* 생성된 랜덤 넘버를 보고, Car 객체가 전진할지 계산*/
    public void calcScore(int numberOfCar, Car[] carArray) {
        RandomNumberGenerator prng = new RandomNumberGenerator(numberOfCar);
        ArrayList<Boolean> direction = prng.goNoGo();
        for (int i = 0; i < numberOfCar; i++) {
            if (direction.get(i)) {
                carArray[i].setPosition(carArray[i].getPosition() + 1);
            }
        }
    }

    /* Car들의 점수를 보고 우승자 계산 */
    public ArrayList<Car> calcWinner(Car[] carArray) {
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

        ArrayList<Car> winner = new ArrayList<Car>();
        winner.add(carArray[0]);
        for (int i = 1; i < carArray.length; i++) {
            if (carArray[i].getPosition() == carArray[0].getPosition()) {
                winner.add(carArray[i]);
                continue;
            }
            break;
        }
        return winner;
    }
}
