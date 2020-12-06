package racingcar.controller;

import racingcar.domain.CarMovingFlag;
import racingcar.game.RacingCarManager;
import utils.CarMovingFlagUtils;

import java.util.List;
import java.util.Scanner;

public class RacingGrameController {
    private static final int START_INDEX = 0;

    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    public RacingGrameController(final Scanner scanner) {
        this.inputViewer = new InputViewer(scanner);
        this.outputViewer = new OutputViewer();
    }

    public void playRacingCarGame() {
        RacingCarManager racingCarManager = this.racingCarManager();

        int howManyTry = this.getValidateTryNumber();
        this.outputViewer.printHeadMessageBeforePrintResult();
        for (int indexOfTry = START_INDEX; indexOfTry < howManyTry; indexOfTry++) {
            this.eachRacingTryingMoment(racingCarManager);
        }
        List<String> winnerCarNameList = racingCarManager.getNowWinnerPlayersName();
        this.outputViewer.printWinnerResultMessage(winnerCarNameList);
    }

    private int getValidateTryNumber() {
        while (true) {
            try {
                this.outputViewer.printInputHowManyTryMessage();
                return this.inputViewer.inputTryNumber();
            } catch (IllegalArgumentException exception) {
                this.outputViewer.printErrorInputTypeMessage();
            }
        }
    }

    private void eachRacingTryingMoment(RacingCarManager racingCarManager) {
        List<Integer> randomFlagNumberList = this.inputViewer.makeRandomZeroToNineBoundedNumberList(racingCarManager.numberOfRacingCar());
        List<CarMovingFlag> carMovingFlagList = CarMovingFlagUtils.makeCarMovieFlagList(randomFlagNumberList);
        racingCarManager.updateRacingCarPosition(carMovingFlagList);
        this.outputViewer.printEachTryResult(racingCarManager.nowPositionResultStrList());
    }

    private RacingCarManager racingCarManager() {
        while (true) {
            try {
                this.outputViewer.printInputCarNameMessage();
                return new RacingCarManager(this.inputViewer.inputCarNameList());
            } catch (IllegalArgumentException exception) {
                this.outputViewer.printExceedMaxLenCarNameErrorMessage();
            }
        }
    }
}