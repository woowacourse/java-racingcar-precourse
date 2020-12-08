package Race;

import View.OutputView;
import racingcar.Car;
import racingcar.Cars;

import java.util.List;

public class Referee {
    private OutputView winnerBoard = new OutputView();
    private List<String> winners = null;

    public Referee() {

    }

    private void saveAllWinner(Cars cars) {
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
