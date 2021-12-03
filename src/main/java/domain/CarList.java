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
        final int max = carList.stream()
                .mapToInt(car->car.getPosition())
                .max()
                .getAsInt();

        List<String> winnerList = carList.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());

        return winnerList;

    }

}
