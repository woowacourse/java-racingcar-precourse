package racingcar.controller;

import racingcar.domain.CarMovingFlag;
import racingcar.game.RacingCarManager;
import utils.CarMovingFlagUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGrameController {
    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    public RacingGrameController(final Scanner scanner) {
        this.inputViewer = new InputViewer(scanner);
        this.outputViewer = new OutputViewer();
    }

    public void playRacingCarGame() {
        RacingCarManager racingCarManager = this.racingCarManager();

        int howManyTry = this.getValidateTryNumber();
        for (int indexOfTry = 0; indexOfTry < howManyTry; indexOfTry += 1) {
            this.eachRacingTryingMoment(racingCarManager);
        }
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
        List<CarMovingFlag> carMovingFlagList = this.makeCarMovieFlagList(randomFlagNumberList);
    }

    private List<CarMovingFlag> makeCarMovieFlagList(List<Integer> flagNumberList) {
        List<CarMovingFlag> carMovingFlagList = new ArrayList<>(flagNumberList.size());
        for (int flagNumber : flagNumberList) {
            carMovingFlagList.add(CarMovingFlagUtils.selectMovingFlag(flagNumber));
        }

        return carMovingFlagList;
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