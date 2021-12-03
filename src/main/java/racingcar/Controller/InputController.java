package racingcar.Controller;

import racingcar.Model.Input;
import racingcar.Service.AttemptValidationService;
import racingcar.Service.NameValidationService;
import racingcar.View.InputView;

public class InputController {
    final Input input = new Input();

    public Input setAndGetInput() {
        getName();
        getAttempt();
        return this.input;
    }

    private void getName() {
        try {
            String[] names = InputView.inputName().replaceAll(" ", "").split(",");
            NameValidationService.isValidNames(names);
            input.setNames(names);
        } catch (IllegalArgumentException e) {
            getName();
        }
    }

    private void getAttempt() {
        try {
            String attempt = InputView.inputAttempt();
            AttemptValidationService.isValidAttempt(attempt);
            input.setAttempt(Integer.parseInt(attempt));
        } catch (IllegalArgumentException e) {
            getAttempt();
        }
    }

}
