package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;
import util.RandomNumberGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarSystem {
    private static final int MOVE_CONDITION = 4;
    private List<Car> cars = new LinkedList<>();

    public void setUpRacing() {
        String carsName = InputRacingCar.inputCarsName();
        setCarList(carsName);
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

    public void startRacing() {
        int repeatTimes = InputRacingCar.inputRepeatTimes();
        OutputRacingCar.printGameResult();
        for (int i = 0; i < repeatTimes; i++) {
            race();
        }
    }

    public void race() {
        for (Car car : cars) {
            decideToMoveCar(car);
            OutputRacingCar.printCarProgress(car);
        }
        System.out.println();
    }

    public void decideToMoveCar(Car car) {
        if (RandomNumberGenerator.getRandomNumber() >= MOVE_CONDITION) {
            car.move();
        }
    }

    public void finishRacing() {
        RankingSystem rankingSystem = new RankingSystem(cars);
        List<String> winnerList = rankingSystem.getWinner();
        OutputRacingCar.printWinner(winnerList);
    }
}
