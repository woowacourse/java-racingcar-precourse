package system;

import domain.Car;
import io.InputRacingCar;
import io.OutputRacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarSystem {
    private int repeatTime;
    private List<Car> cars = new LinkedList<>();

    public void setUpRacing() {
        String carsName = InputRacingCar.inputCarsName();
        setCarList(carsName);
        repeatTime = InputRacingCar.inputRepeatTime();
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
        OutputRacingCar.printGameResult();
        for (int i = 0; i < repeatTime; i++) {
            for (Car car : cars) {
                OutputRacingCar.printCarProgress(car);
                decideToMoveCar(car);
            }
            System.out.println();
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
}
