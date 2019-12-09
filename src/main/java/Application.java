/*
 * @(#)Application.java 2019/12/10
 *
 * Copyright (c) 2019 Geunwon Lim
 * All rights reserved.
 */

import java.util.List;
import java.util.Scanner;

import domain.*;
import ui.Console;
import ui.InputController;
import ui.InputControllerImpl;
import ui.UserInterface;
import util.RacingPrinter;
import util.RacingPrinterImpl;

public class Application {
    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        RacingPrinter racingPrinter = new RacingPrinterImpl();
        UserInterface userInterface = setupUserInterface(validator, racingPrinter);

        String[] names = userInterface.extractNames();

        RacingGame racingGame = setupRacingGame(validator, names, racingPrinter);

        int cycles = userInterface.getCycles();

        try {
            racingGame.play(cycles);
        } catch (RuntimeException e) {
            racingPrinter.printErrorGameFinishedAbnormal(e.getMessage());
            System.exit(-1);
        }

    }

    private static UserInterface setupUserInterface(Validator validator, RacingPrinter racingPrinter) {
        InputController inputController = new InputControllerImpl(new Scanner(System.in));

        return new Console(inputController, validator, racingPrinter);
    }

    private static RacingGame setupRacingGame(Validator validator, String[] names, RacingPrinter racingPrinter) {
        RaceableFactory raceableFactory = new RacingCarFactory(validator);
        List<Raceable> raceables = raceableFactory.create(names);
        RacingReferee racingReferee = new RacingRefereeImpl();

        return new RacingGameImpl(raceables, racingReferee, racingPrinter);

    }
}
