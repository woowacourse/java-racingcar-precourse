package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.*;

public class RaceGame {
    private InputChecker inputChecker;
    private ArrayList<Car> raceCarList = new ArrayList<>();

    private int tryNumber;

    public RaceGame(InputChecker inputChecker) {
        this.inputChecker = inputChecker;
    }

    public void startGame() {
        askCarNames();
        askTryNumber();
        startRace();
    }

    private void askCarNames() {
        try {
            System.out.println(GameData.MESSAGE_ASK_CAR_NAMES);
            String[] carNames = readLine().split(",");

            for (String carName : carNames) {
                inputChecker.checkCarName(carName);
            }
            addNewRaceCars(carNames);
        } catch (IllegalArgumentException exception) {
            askCarNames();
        }
    }

    private void askTryNumber() {
        try {
            System.out.println(GameData.MESSAGE_ASK_TRY_NUMBER);
            String tryNumber = readLine();

            inputChecker.checkTryNumber(tryNumber);
            this.tryNumber = Integer.parseInt(tryNumber);
        } catch (IllegalArgumentException exception) {
            askTryNumber();
        }
    }

    private void addNewRaceCars(String[] carNames) {
        raceCarList.clear();
        for (String carName : carNames) {
            raceCarList.add(new Car(carName));
        }
    }

    private void startRace() {
        System.out.println(GameData.MESSAGE_GAME_RESULT);
        for (int i = 0; i < tryNumber; i++) {
            tryRace();
        }
    }

    private void tryRace() {
        for (Car raceCar : raceCarList) {
            raceCar.tryMove();
            raceCar.printStatus();
        }
        System.out.println();
    }

    public interface InputChecker {
        void checkCarName(String input);

        void checkTryNumber(String input);
    }
}
