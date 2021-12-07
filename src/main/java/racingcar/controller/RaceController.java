package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.service.RaceService;
import racingcar.view.RaceInputView;
import racingcar.view.RaceOutputView;

public class RaceController {
    private final RaceService raceService;
    private final RaceInputView raceInputView;
    private final RaceOutputView raceOutputView;

    public RaceController() {
        this.raceService = new RaceService();
        this.raceInputView = new RaceInputView();
        this.raceOutputView = new RaceOutputView();
    }

    public void run() {
        setRace();
        startRace();
        finishRace();
    }

    public void setRace() {
        String[] carNames = raceInputView.inputCarName();
        int numberOfRaces = raceInputView.inputNumberOfRaces();
        RacingCars racingCars = raceService.createRacingCars(carNames);
        raceService.createRace(numberOfRaces, racingCars);
    }

    public void startRace() {
        raceOutputView.outputExecutionResult(raceService.repeatRace());
    }

    public void finishRace() {
        raceOutputView.outputWinner(raceService.getRaceWinners());
    }
}
