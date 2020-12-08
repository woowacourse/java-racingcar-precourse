package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getMaxPosition() {
        int max = 0;
        for (Car car : this.cars) {
            int position = car.getPosition();
            if (position > max) {
                max = position;
            }
        }
        return max;
    }
}
