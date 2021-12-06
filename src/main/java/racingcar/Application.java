package racingcar;

import controller.RacingController;
import model.movement.Movement;
import model.movement.RandomMovement;
import view.input.InputDisplayable;
import view.input.InputView;
import view.output.OutputDisplayable;
import view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputDisplayable outputDisplayable = new OutputView();
        InputDisplayable inputDisplayable = new InputView();
        Movement movement = new RandomMovement();
        RacingController racingController = new RacingController(inputDisplayable, outputDisplayable, movement);
        racingController.run();
    }
}
