package racingcar.controller;

import racingcar.view.UserInput;

public class MainController {
    UserInput userInput;

    public MainController() {
        userInput = new UserInput();
    }

    public void playGame(){
        String carNames = userInput.inputCarNames();
        UserInputValidation.carNameValidation(carNames);
    }
}
