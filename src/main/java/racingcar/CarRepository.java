package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> carList = new ArrayList<>();
    private final static int DEFAULT_VALUE = 0;

    private final static CarRepository instance = new CarRepository();

    private CarRepository(){
    }

    public static CarRepository getInstance(){
        return instance;
    }

    public int saveAll(List<Car> cars){
        for (Car car : cars) {
            carList.add(car);
        }
        return carList.size();
    }

    public List<Car> findAll(){
        return carList;
    }

    public void clear(){
        int size = carList.size();
        for(int i = 0; i < size; i++){
            carList.remove(DEFAULT_VALUE);
        }
    }

}
