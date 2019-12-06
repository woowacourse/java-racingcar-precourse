package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarSystem {
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
        int repeatTime = InputRacingCar.inputRepeatTime();
        OutputRacingCar.printGameResult();
        for (int i = 0; i < repeatTime; i++) {
            race();
            System.out.println();
        }
    }

    public void race() {
        for (Car car : cars) {
            decideToMoveCar(car);
            OutputRacingCar.printCarProgress(car);
        }
    }

    public void decideToMoveCar(Car car) {
        if (createRandomNumber() > 3) {
            car.move();
        }
    }

    public int createRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public void finishRacing() {
        RankingSystem rankingSystem = new RankingSystem(cars);
        List<String> winnerList = rankingSystem.getWinner();
        OutputRacingCar.printWinner(winnerList);
    }
}
