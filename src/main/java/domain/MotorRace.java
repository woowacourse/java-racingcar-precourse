package domain;

public class MotorRace {
    public static void main(String[] args) {
        CarSetting carSetting = new CarSetting();
        carSetting.carSet();
        Car[] cars = carSetting.getCars();
        int count = carSetting.getCount();
        MotorRace motorRace = new MotorRace();
        motorRace.goingCars(cars, count);
        motorRace.checkWinner(cars);
    }

    void goingCars(Car[] cars, int count) {
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                car.goingForward();
            }
            carsConditions(cars);
        }
    }

    void carsConditions(Car[] cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    void checkWinner(Car[] cars) {
        String winner = "";
        int max = 0;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                winner = (car.getName() + ", ");
            } else if (max == car.getPosition()) {
                winner += (car.getName() + ", ");
            }
        }
        System.out.println(winner.substring(0, winner.length() - 2) + "(이)가 최종 우승했습니다.");
    }
}
