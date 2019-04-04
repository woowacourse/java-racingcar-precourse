package com.nekisse;

import com.nekisse.domain.CarName;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String inputString = InputView.getInputCarName();

        List<CarName> carNames = Utils.parseStringToGetCarNames(inputString);

        int inputTryCount = InputView.getInputTryCount();

        GameMachine gameMachine = new GameMachine(inputTryCount, carNames, new GameRandomNumberGenerator());
        int startnumber = 0;
        while (startnumber<inputTryCount) {
            TurnResult turnResult = gameMachine.runCar();
            OutPutView.showTurnResult(turnResult);
            OutPutView.printEmptyLine();

            startnumber++;
        }



    }

}
