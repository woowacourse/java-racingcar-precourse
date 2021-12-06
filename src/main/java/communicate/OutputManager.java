package communicate;

import racingcar.Car;

public class OutputManager {
    public void printCarsInformation(Car car) {
        System.out.println(car.provideInformation());
    }
}
