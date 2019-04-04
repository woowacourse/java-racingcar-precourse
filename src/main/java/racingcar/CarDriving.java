package racingcar;

import racingcar.domain.Car;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

public class CarDriving {
    private static int GO = 4;

    public static void move(RacingCars carCollection) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (Car car : carCollection.getCars())
            if (stopOrGo(numberGenerator))
                car.increasePosition();
    }

    private static boolean stopOrGo(NumberGenerator numberGenerator) {
        return numberGenerator.getNumber() >= GO;
    }
}
