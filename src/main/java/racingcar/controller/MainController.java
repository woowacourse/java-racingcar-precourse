package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class MainController {
    private static final String PRINT_RESULT = "실행 결과";

    private List<Car> carList;
    private int tryNum;

    public MainController() {
    }

    public void playGame() {
        saveCarList();
        saveTryNum();

        raceStart(carList);
        OutputController.finalWinner(carList);
    }

    private void saveCarList() {
        while (true) {
            String carValue = Input.inputCarNames();

            try {
                InputValidation.carNameValidation(carValue);
                carList = CarController.saveCarList(carValue);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveTryNum() {
        while (true) {
            String tryValue = Input.inputTry();

            try {
                InputValidation.tryNumValidation(tryValue);
                tryNum = Integer.parseInt(tryValue);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void raceStart(List<Car> carList) {
        System.out.println(PRINT_RESULT);

        for (int i = 0; i < tryNum; i++) {
            CarController.movePosition(carList);
            Output.racePrint(carList);
        }
    }
}
