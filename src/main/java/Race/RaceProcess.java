package Race;

import Domain.Car;
import Domain.Cars;
import View.OutputView;

import java.util.List;

public class RaceProcess {

    private Cars cars;
    private int carNum = 0;
    private int roundNum = 0;
    private OutputView scoreBoard = new OutputView();

    public RaceProcess(int roundNum, Cars cars) {
        this.roundNum = roundNum;
        this.cars = cars;
        this.carNum = cars.getCarNum();
    }

    public void totalRoundProcess() {
        for(int index = 0; index < this.roundNum; index++) {
            this.oneRoundProcess();
            this.currentResult(this.cars);
        }
    }

    private void oneRoundProcess() {
        for(int index = 0; index < this.carNum; index++) {
            this.cars.getCar(index).tryingMove();
        }
    }

    private void currentResult(Cars cars) {
        Car currentCar;
        for(int index = 0; index < this.carNum; index++) {
            currentCar = cars.getCar(index);
            scoreBoard.showState(currentCar.getName(), currentCar.getScore());
        }
        scoreBoard.printLine();
    }






}
