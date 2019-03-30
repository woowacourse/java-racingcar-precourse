package domain;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        String[] carNames = null;
        int cnt = 0;
        boolean flag = false;

        while (!flag) {
            carNames = ui.inputCarNames();
            flag = ui.checkValidationCarNames(carNames);
        }

        flag = false;
        while (!flag) {
            cnt = ui.inputCnt();
            flag = ui.checkValidationCnt(cnt);
        }

        Car[] cars = Car.createCars(carNames);

        for (int i = 0; i < cnt; i++) {
            for (Car car : cars) {
                car.updatePosition();
            }
            ui.printRacing(cars);
        }

        ui.printWinners(cars);
    }
}
