package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.StrictMath.max;

public class Cars {
    CarList carList = new CarList();
    TryNumber tryNumber = new TryNumber();

    public List<Car> getCarList() {
        return carList.getCarList();
    }

    public int getTryNumber() {
        return Integer.parseInt(this.tryNumber.getTryNumber());
    }

    public void setTryNumber(String tryNumber) {
        this.tryNumber.setTryNumber(tryNumber);
    }

    public void addCars(String carNames) {
        for (String carName : carNames.split(",")) {
            carList.add(carName);
        }
    }

    public int getCarsPosition(){
        List<Integer> carPositionList = new ArrayList<Integer>();
        for (Car car : carList.getCarList()){
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

    public String getWinner(int maxPosition){
        List<String> winnerList = new ArrayList<String>();

        for (Car car : carList.getCarList()){
            if (maxPosition == car.getPosition()){
                winnerList.add(car.getName());
            }
        }
       return String.join(", ",winnerList);
    }
}
