package racingcar.service;

import racingcar.model.Car;
import racingcar.model.RacingCars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingCarGameService {

    private static final String CAR_NAME_SPLIT_REGEX = ",";

    private RacingCars racingCars;

    private List<Car> cars = new ArrayList<>();

    public void generateRacingCars(String inputCarName) {
        for (String carName : inputCarName.split(CAR_NAME_SPLIT_REGEX)) {
            Car generatedCar = new Car(carName);
            cars.add(generatedCar);
        }
        racingCars = new RacingCars(cars);
    }

    public void forwardTry() {
        racingCars.forwardTry();
    }

    public List<Map<String, String>> getForwardTryResult() {
        List<Map<String, String>> racingCarsInfo = new ArrayList<>();
        List<Car> triedRacingCars = racingCars.getRacingCars();
        for (Car triedRacingCar : triedRacingCars) {
            Map<String, String> carInfos = triedRacingCar.getCarInfos();
            racingCarsInfo.add(carInfos);
        }
        return racingCarsInfo;
    }
}
