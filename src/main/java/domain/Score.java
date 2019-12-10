package domain;

import java.util.ArrayList;
import java.util.Comparator;

public class Score {

    public void calcScore(int numberOfCar, CarList carList) {
        RandomNumberGenerator prng = new RandomNumberGenerator(numberOfCar);
        ArrayList<Boolean> direction = prng.goNoGo();
        for (int j = 0; j < numberOfCar; j++) {
            int previousPosition = carList.car.get(j).getPosition();
            if (direction.get(j)) {
                carList.car.get(j).setPosition(previousPosition + 1);
            }
        }
    }

    public ArrayList<Car> calcWinner(CarList carList) {
        carList.car.sort(new Comparator<Car>() {
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
        winner.add(carList.car.get(0));
        for (int i = 1; i < carList.car.size(); i++) {
            if (carList.car.get(i).getPosition() == carList.car.get(0).getPosition()) {
                winner.add(carList.car.get(i));
                continue;
            }
            break;
        }
        return winner;
    }
}
