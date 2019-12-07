package domain;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getPosition() < car2.getPosition()) {
            return 1;
        }
        return -1;
    }

}
