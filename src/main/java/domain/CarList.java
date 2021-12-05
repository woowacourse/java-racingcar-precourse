package domain;

import utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private List<Car> carList;
    private Validation validation = new Validation();

    public CarList(String inputCarList){
        try{
            validation.carValidate(inputCarList);
        }catch (IllegalArgumentException e){
            throw e;
        }

        String[] carNameList = inputCarList.split(",");
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
