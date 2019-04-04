import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingCarResult {
    private List<Car> cars;

    public RacingCarResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        List<Car> winnerCars = new ArrayList<>();

        Collections.sort(cars, carComparator);

        int maxPosition = cars.get(0).getPosition();

        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getPosition() == maxPosition)
                winnerCars.add(cars.get(i));
        }

        return winnerCars;
    }

    Comparator<Car> carComparator = new Comparator<Car>() {
        @Override
        public int compare(Car c1, Car c2) {
            if(c1.getPosition() < c2.getPosition())
                return 1;
            else if(c1.getPosition() > c2.getPosition())
                return -1;
            else
                return 0;
        }
    };
} 
