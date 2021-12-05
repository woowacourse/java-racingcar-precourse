package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private List<Car> carList;

    public CarList(String... carNameList){

        carList = new ArrayList<>();

        for(String carName:carNameList){
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList(){
        return this.carList;
    }

    public List<String> decideWinner(){
        Car maxCar = carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException());

        List<String> winnerList = carList.stream()
                .filter(maxCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        return winnerList;

    }

}
