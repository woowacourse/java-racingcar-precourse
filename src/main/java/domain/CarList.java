package domain;

import java.util.ArrayList;
import java.util.List;

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

}
