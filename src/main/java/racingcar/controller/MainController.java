package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        raceStart(carList);
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

    private void raceStart(List<Car> carList) {
        for (int i=0; i<tryNum; i++) {
            CarController.movePosition(carList);
            OutputView.racePrint(carList);
        }
    }
}
