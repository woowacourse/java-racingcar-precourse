package domain;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        String[] carNames = null;
        String cntStr = "";
        int cnt = 0;
        boolean flag = false;

        while (!flag) {
            carNames = ui.inputCarNames();
            flag = ui.checkValidationCarNames(carNames);
        }

        flag = false;
        while (!flag) {
            cntStr = ui.inputCnt();
            flag = ui.checkValidationCnt(cntStr);
        }

        cnt = Integer.parseInt(cntStr);
        Car[] cars = new Car[carNames.length];
        int idx = 0;
        for (String carName : carNames) {
            cars[idx++] = new Car(carName);
        }

        ui.printResultMenu();
        for (int i = 0; i < cnt; i++) {
            for (Car car : cars) {
                car.updatePosition();
            }
            ui.printRacing(cars);
        }

        ui.printWinners(cars);
    }
}
