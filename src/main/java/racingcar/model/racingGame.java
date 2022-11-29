package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class racingGame {

    public List<Car> saveCars(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<carNames.length; i++) {
            String name = carNames[i];
            cars.add(new Car(name,0));
        }
        return cars;
    }

}
