package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarSystem {
    private List<Car> cars = new LinkedList<>();

    public void run() {
        String carsName = InputRacingCar.inputCarsName();
        setCarList(carsName);

        RacingSystem racingSystem = new RacingSystem(cars);
        racingSystem.startRacing();

        RankingSystem rankingSystem = new RankingSystem(cars);
        List<String> winnerList = rankingSystem.getWinner();
        OutputRacingCar.printWinner(winnerList);
    }

    public void setCarList(String carsName) {
        StringTokenizer st = splitCarName(carsName);

        while (st.hasMoreTokens()) {
            createCar(st.nextToken());
        }
    }

    public StringTokenizer splitCarName(String carsName) {
        return new StringTokenizer(carsName, ",");
    }

    public void createCar(String carName) {
        cars.add(new Car(carName));
    }
}
