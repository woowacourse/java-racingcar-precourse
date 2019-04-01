package domain;

/**
 * Main 클래스로 racing 게임을 진행하는 class
 *
 * @author 송윤재
 * @version 1.0 2019/04/01
 */
public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        String[] carNames = null;
        String cntStr = "";
        int cnt = 0;
        boolean flag = false;

        // 자동차 이름을 받는 곳
        while (!flag) {
            carNames = ui.inputCarNames();
            flag = ui.checkValidationCarNames(carNames);
        }

        // 반복할 회수를 입력받는 곳
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

        // 자동차 경주를 진행하는 곳
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
