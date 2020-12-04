package racingcar;

import java.util.Scanner;

public class GameManager {
    private Scanner scanner;

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        GameData gameData = setupGameData();
        
        OutputHandler.printRunMessage();
        move(gameData);
    }
    
    private GameData setupGameData() {
        InputHandler inputHandler = new InputHandler(scanner);
        
        CarList carList = new CarList(inputHandler.askCarNames());
        int moveCount = inputHandler.askMoveCount();

        return new GameData(carList, moveCount);
    }

    private void move(GameData gameData) {
        for (int i = 0; i < gameData.moveCount; i++) {
            moveAllCars(gameData.carList);
            OutputHandler.printCarList(gameData.carList);
        }
    }

    private void moveAllCars(CarList carList) {
        carList.moveAllCars();
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
