package racingcar;

import java.util.ArrayList;

public class Winner {
    private ArrayList<Car> carList;
    private Integer maxPosition = 0;

    public Winner(ArrayList<Car> carList) {
        this.carList = carList;
        getMaxPosition();
    }

    private void getMaxPosition() {
        for (Car car: carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
    }

    public ArrayList<String> findWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        carList.forEach(car -> {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        });
        return winnerList;
    }
}
