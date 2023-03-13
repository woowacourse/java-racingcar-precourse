package racingcar.Controller;

import racingcar.Domain.CarGame;
import racingcar.Domain.CarGameGenerator;
import racingcar.Domain.Cars;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class GameController {

    private CarGame carGame;
    public void startGame(){
        makeCarGame();
    }

    public void makeCarGame(){
        carGame = CarGameGenerator.makeCarGame(askCars()); // 인자로 car을 넘겨줘야 하는데
    }
    public Cars askCars(){
        OutputView.printInputCarName();
        return new ReEnterProcessor<>(InputView::readCarName, OutputView::printExceptionMessage).process();
    }

}
