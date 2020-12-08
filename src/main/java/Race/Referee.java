package Race;

import View.OutputView;
import Domain.Car;
import Domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<String> winners = new ArrayList<String>();

    public Referee() {

    }

    public List<String> getWinners() {
        return this.winners;
    }

    public void saveAllWinner(Cars cars) {
        int maxScore = cars.getMaxScore();
        int carNum = cars.getCarNum();
        Car currentCar;

        for(int index = 0; index < carNum; index++) {
            currentCar = cars.getCar(index);
            if(this.isWinner(currentCar, maxScore)) {
                this.winners.add(currentCar.getName());
            }
        }
    }

    private boolean isWinner(Car car, int winnerScore) {
        return car.getScore() == winnerScore;
    }
}
