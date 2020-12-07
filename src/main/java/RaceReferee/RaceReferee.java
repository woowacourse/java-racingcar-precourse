package RaceReferee;

import java.util.Collections;
import java.util.Comparator;
import racingcar.Car;
import View.OutputView;

import java.util.List;

public class RaceReferee {

    private List<Car> Cars;
    private int carNum = 0;
    private int roundNum = 0;
    private OutputView scoreBoard = new OutputView();

    public RaceReferee(List<String> carNames, int roundNum) {
        this.roundNum = roundNum;
        this.carNum = carNames.toArray().length;

        createCars(carNames);
    }

    public void createCars(List<String> carNames) {
        for(int index = 0; index < this.carNum; index += 1) {
            this.Cars.add(new Car(carNames.get(index)));
        }
    }

    public void totalRoundProcess(int roundNum) {
        for(int index = 0; index < roundNum; index++) {
            this.oneRoundProcess();
            this.currentResult();
        }
    }

    private void oneRoundProcess() {
        for(int index = 0; index < this.carNum; index++) {
            Cars.get(index).tryingMove();
        }
    }

    private void currentResult() {
        Car currentCar;
        for(int index = 0; index < this.carNum; index++) {
            currentCar = Cars.get(index);
            scoreBoard.showState(currentCar.getName(), currentCar.getScore());
        }
    }
    




}
