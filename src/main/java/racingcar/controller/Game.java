package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.domain.Car;
import racingcar.domain.GameBoard;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final InputView inputView;
    private GameBoard gameBoard;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        setGameBoard();
        int attemptCount = this.inputView.scanAttemptCount();
        printScoreboard(attemptCount);
        OutputView.printWinner(gameBoard.getWinner());
    }

    private void setGameBoard() {
        GameBoard gameBoard = new GameBoard(makeCars());
        this.gameBoard = gameBoard;
    }

    private List<Car> makeCars() {
        List<String> carNameList = this.inputView.scanCarName();
        List<Car> carList = new ArrayList<Car>();
        for (int idx = 0; idx < carNameList.size(); idx++) {
            Car car = new Car(carNameList.get(idx));
            carList.add(car);
        }
        return carList;
    }

    private void printScoreboard(int attemptCount) {
        OutputView.printResultMessage();
        for (int round = 0; round < attemptCount; round++) {
            OutputView.printRoundResult(this.gameBoard.runRound());
        }
    }
}
