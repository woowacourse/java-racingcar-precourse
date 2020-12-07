package Race;

import racingcar.Car;
import racingcar.Cars;
import View.OutputView;

import java.util.List;


public class RaceProcess {

    private List<Car> Cars;
    private int carNum = 0;
    private int roundNum = 0;
    private OutputView scoreBoard = new OutputView();

    public RaceProcess(int roundNum) {
        this.roundNum = roundNum;
    }



    public void totalRoundProcess(int roundNum, Cars cars) {
        for(int index = 0; index < roundNum; index++) {
            this.oneRoundProcess();
            this.currentResult(cars);
        }
    }

    private void oneRoundProcess() {
        for(int index = 0; index < this.carNum; index++) {
            Cars.get(index).tryingMove();
        }
    }

    private void currentResult(Cars cars) {
        Car currentCar;
        for(int index = 0; index < this.carNum; index++) {
            currentCar = cars.getCar(index);
            scoreBoard.showState(currentCar.getName(), currentCar.getScore());
        }
    }






}
