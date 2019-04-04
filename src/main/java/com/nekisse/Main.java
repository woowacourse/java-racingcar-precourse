package com.nekisse;

import com.nekisse.domain.CarName;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputString = InputView.getInputCarName();

        List<CarName> carNames = Utils.parseStringToGetCarNames(inputString);

        int inputTryCount = InputView.getInputTryCount();

        GameMachine gameMachine = new GameMachine(inputTryCount, carNames, new GameRandomNumberGenerator());

        while (gameMachine.isEndGame()) {
            TurnResult turnResult = gameMachine.runCar();
            OutPutView.showTurnResult(turnResult);
            OutPutView.printEmptyLine();
        }
        WiningCars winingCars = new WiningCars(gameMachine);
        OutPutView.printWiningCars(winingCars);
    }
}
