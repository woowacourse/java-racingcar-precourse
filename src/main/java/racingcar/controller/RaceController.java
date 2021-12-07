package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.service.RaceService;
import racingcar.view.RaceInputView;

public class RaceController {
    private final RaceService raceService;
    private final RaceInputView raceInputView;

    public RaceController() {
        this.raceService = new RaceService();
        this.raceInputView = new RaceInputView();
    }

    public void run() {
        setRace();
    }

    public void setRace() {
        String[] carNames = raceInputView.inputCarName();
        int numberOfRaces = raceInputView.inputNumberOfRaces();
        RacingCars racingCars = raceService.createRacingCars(carNames);
        raceService.createRace(numberOfRaces, racingCars);
    }
}
