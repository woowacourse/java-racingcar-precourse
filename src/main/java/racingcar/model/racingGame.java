package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class racingGame {

    public List<Car> saveCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            String name = carNames[i];
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    public void updatePhase(List<Car> cars) {
        for (int j = 0; j < cars.size(); j++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                cars.get(j).setPosition(cars.get(j).getPosition() + 1);
            }
        }
    }
}
