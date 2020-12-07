package racingcar.domain.car.carfactory;

import racingcar.domain.car.CarInterface;

public abstract class Factory {
    public final CarInterface deliverCar(String name) {
        CarInterface car = manufactureCar(name);
        return car;
    }

    protected abstract CarInterface manufactureCar(String name);
}
