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
        playGame();
    }

    public void makeCarGame(){
        this.carGame = CarGameGenerator.makeCarGame(askCars()); // 인자로 car을 넘겨줘야 하는데
    }
    public Cars askCars(){
        OutputView.printInputCarName();
        return new ReEnterProcessor<>(InputView::readCarName, OutputView::printExceptionMessage).process();
    }
    public void playGame(){
        int tryNum = askTry();
        for(int i =0; i< tryNum; i++){
            carGame.playRound();
            OutputView.showRoundResult(carGame.getCars());
        }
    }

    public int askTry(){
        OutputView.printInputTryCount();
        return new ReEnterProcessor<>(InputView::readTryCount, OutputView::printExceptionMessage).process();

    }

}
