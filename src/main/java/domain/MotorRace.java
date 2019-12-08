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
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
