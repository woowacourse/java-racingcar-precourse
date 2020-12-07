package RaceReferee;

import racingcar.Car;

import java.util.List;

public class RaceReferee {

    private List<Car> Cars;
    private int carNum = 0;
    private int roundNum = 0;

    public RaceReferee(List<String> carNames, int roundNum) {
        this.roundNum = roundNum;
        createCars(carNames);
    }

    public void createCars(List<String> carNames) {
        this.carNum = carNames.toArray().length;

        for(int index = 0; index < this.carNum; index += 1) {
            this.Cars.add(new Car(carNames.get(index)));
        }
    }

    public void totalRoundProcess(int roundNum) {
        for(int index = 0; index < roundNum; index++) {
            oneRoundProcess();
        }
    }

    private void oneRoundProcess() {
        for(int index = 0; index < this.carNum; index++) {
            Cars.get(index).tryingMove();
        }
    }

    private void scoreBoard() {
        Car currentCar;

        for(int index = 0; index < this.carNum; index++) {
            currentCar = Cars.get(index);

            System.out.println();
        }
    }
    




}
