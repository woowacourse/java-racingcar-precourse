package racingcar;

import controller.RacingController;
import model.movement.Movement;
import model.movement.RandomMovement;
import view.input.InputDisplayable;
import view.input.ConsoleInputView;
import view.output.OutputDisplayable;
import view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        OutputDisplayable outputDisplayable = new ConsoleOutputView();
        InputDisplayable inputDisplayable = new ConsoleInputView();
        Movement movement = new RandomMovement();
        RacingController racingController = new RacingController(inputDisplayable, outputDisplayable, movement);
        racingController.run();
    }
}
