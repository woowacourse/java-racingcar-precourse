package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {

    public List<Car> makeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public List<Car> oneTrialGame(List<Car> carList) {
        for (Car car : carList) {
            car.tryMove();
        }
        return carList;
    }

    public void printMove(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
    }

    public int winnerPosition(List<Car> carList) {
        List<Integer> carPosition = new ArrayList<>();
        for (Car car : carList) {
            carPosition.add(car.getPosition());
        }
        return Collections.max(carPosition);
    }

    public List<String> getWinnersList(List<Car> carList, int winnerPosition) {
        List<String> winners = new ArrayList<>();
        for(Car car : carList) {
            if(car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }



}
