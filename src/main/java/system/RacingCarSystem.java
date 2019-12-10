package system;

import domain.Car;
import domain.RacingCars;
import io.InputRacingCar;
import io.OutputRacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarSystem {
    public void run() {
        String carsName = InputRacingCar.inputCarsName();
        RacingCars racingCars = new RacingCars(createRacingCars(carsName));
        List<Car> racingCarsList = racingCars.getCarList();

        RacingSystem racingSystem = new RacingSystem(racingCarsList);
        racingSystem.startRacing();

        RankingSystem rankingSystem = new RankingSystem(racingCarsList);
        List<String> winnerList = rankingSystem.getWinner();
        OutputRacingCar.printWinner(winnerList);
    }

    private List<Car> createRacingCars(String carsName) {
        List<Car> cars = new LinkedList<>();

        StringTokenizer st = splitCarName(carsName);
        while (st.hasMoreTokens()) {
            String carName = st.nextToken();
            addCar(cars, carName);
        }
        return cars;
    }

    private StringTokenizer splitCarName(String carsName) {
        return new StringTokenizer(carsName, ",");
    }

    private void addCar(List<Car> cars, String carName) {
        cars.add(new Car(carName));
    }
}
