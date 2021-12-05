package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.List;

public class MainController {
    private List<Car> carList;
    private int tryNum;

    public MainController() {
    }

    public void playGame() {
        saveCarList();
        saveTryNum();
        System.out.println("실행 결과");
        CarController.movePosition(carList);
    }

    private void saveCarList() {
        while (true) {
            String carValue = InputView.inputCarNames();

            try {
                UserInputValidation.carNameValidation(carValue);
                carList = CarController.saveCarList(carValue);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveTryNum() {
        while (true) {
            String tryValue = InputView.inputTry();

            try {
                UserInputValidation.tryNumValidation(tryValue);
                tryNum = Integer.parseInt(tryValue);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
