package racingcar;

import java.util.List;
import java.util.Scanner;

public class GameManager {
    private Scanner scanner;

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        GameData gameData = setupGameData();
        move(gameData);
        showResult(gameData);
    }
    
    private GameData setupGameData() {
        InputHandler inputHandler = new InputHandler(scanner);
        
        CarList carList = new CarList(inputHandler.askCarNames());
        int moveCount = inputHandler.askMoveCount();

        return new GameData(carList, moveCount);
    }

    private void move(GameData gameData) {
        OutputHandler.printRunMessage();
        for (int i = 0; i < gameData.moveCount; i++) {
            moveAllCars(gameData.carList);
            OutputHandler.printCarList(gameData.carList);
        }
    }

    private void moveAllCars(CarList carList) {
        carList.moveAllCars();
    }

    private void showResult(GameData gameData) {
        List<String> winners = getWinners(gameData.carList);
        OutputHandler.printWinners(winners);
    }

    private List<String> getWinners(CarList carList) {
        return carList.getWinners();
    }

    private class GameData {
        public CarList carList;
        public int moveCount;

        public GameData(CarList carList, int moveCount) {
            this.carList = carList;
            this.moveCount = moveCount;
        }
    }
}
