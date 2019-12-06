package system;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankingSystem {
    private List<Car> cars;

    public RankingSystem(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<String> getWinner() {
        List<String> winnerList = new ArrayList<>();

        Collections.sort(cars);
        int maxPosition = cars.get(0).getPosition();
        for (Car c : cars) {
            if (c.getPosition() != maxPosition)
                break;
            winnerList.add(c.getName());
        }
        return winnerList;
    }
}
