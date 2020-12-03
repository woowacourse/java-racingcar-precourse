package racingcar;

import utils.Printer;
import utils.RandomUtils;

public class Race {
    public static final int MOVE = 4;
    public static final int MINIMUM_RANGE = 0;
    public static final int MAXIMUM_RANGE = 9;

    public void runCarRace(CarList carList) {
        for (Car car : carList.getCarList()) {
            int moveStatus = RandomUtils.nextInt(MINIMUM_RANGE, MAXIMUM_RANGE);
            if (moveStatus >= MOVE)
                car.setPosition(car.getPosition() + 1);
        }
        Printer.carRacingResult(carList);
    }
}
