package racingcar.controller;

import java.util.Scanner;

public class RacingGrameController {
    private final InputViewer inputViewer;
    private final OutputViewer outputViewer;

    public RacingGrameController(final Scanner scanner) {
        this.inputViewer = new InputViewer(scanner);
        this.outputViewer = new OutputViewer();
    }

    public void playRacingCarGame() {

    }
}