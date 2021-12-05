package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.UserInput;

import java.util.List;

public class MainController {
    private UserInput userInput;

    private List<Car> carList;
    private int tryNum;

    public MainController() {
        userInput = new UserInput();
    }

    public void playGame() {
        saveCarList();
        saveTryNum();
    }

    private void saveCarList() {
        while (true) {
            String carValue = userInput.inputCarNames();

            try {
                UserInputValidation.carNameValidation(carValue);
                carList = CarController.saveCarList(carValue);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveTryNum(){
        while (true) {
            String tryValue = userInput.inputTry();

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
