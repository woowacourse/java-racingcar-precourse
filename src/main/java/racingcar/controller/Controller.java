package racingcar.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import static racingcar.controller.ControllerConstants.*;

public class Controller {
    List<Car> cars;
    int raceTimes;

    public Controller() {
        cars = new ArrayList<Car>();
        raceTimes = 0;
    }

    public void run() {
        setCarNames();
        setRaceTimes();
        race(cars);
        OutputView.printFinalWinners(findFinalWinners());
    }

    private void setCarNames(){
        try {
            String playerInput = InputView.inputCarNames();
            String[] carNames = playerInput.split(SPLIT_DELIMETER);
            for (String carName : carNames) {
                carNameValidator(carName);
                cars.add(new Car(carName));
            }
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            setCarNames();
        }
    }

    private void carNameValidator(String carName) {
        boolean regex = Pattern.matches(CAR_NAME_PATTERN, carName);
        if (!regex) {
            throw new IllegalArgumentException(WRONG_CAR_NAMES);
        }
    }

    private void setRaceTimes(){
        try {
            String playerInput = InputView.inputRaceTimes();
            raceTimesValidator(playerInput);
            raceTimes = Integer.parseInt(playerInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            setRaceTimes();
        }
    }

    private void raceTimesValidator(String playerInput) {
        boolean regex = Pattern.matches(RACE_TIMES_PATTERN, playerInput);
        if (!regex) {
            throw new IllegalArgumentException(WRONG_RACE_TIMES);
        }
    }

    private void race(List<Car> cars) {
        int raceCount = 0;
        while (raceCount <= raceTimes) {
            HashMap<String, Integer> raceResults = new HashMap<>();
            for (Car car : cars) {
                car.race();
                raceResults.put(car.getName(), car.getPosition());
            }
            OutputView.printRaceResults(raceResults);
            raceCount++;
        }
    }

    private List<String> findFinalWinners() {
        List<String> finalWinners = new ArrayList<>();
        int winnerPosition = findWinnerPosition();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                finalWinners.add(car.getName());
            }
        }
        return finalWinners;
    }

    private int findWinnerPosition() {
        int winnerPosition = 0;
        for (Car car : cars) {
            if (winnerPosition < car.getPosition()) {
                winnerPosition = car.getPosition();
            }
        }
        return winnerPosition;
    }
}
