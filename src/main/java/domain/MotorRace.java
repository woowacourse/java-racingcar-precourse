package domain;

public class MotorRace {
    void goingCars(Car[] cars, int count) {
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.goingForward();
            }
            carsConditions(cars);
        }
    }

    void carsConditions(Car[] cars) {

    }
}
