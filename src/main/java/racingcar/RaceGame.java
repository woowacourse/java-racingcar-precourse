package racingcar;

import java.util.ArrayList;
import java.util.Collections;

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
        printWinners(getWinners());
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
        System.out.println(GameData.MESSAGE_GAME_BEGIN);
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

    private ArrayList<Car> getWinners() {
        ArrayList<Car> winnerCars = new ArrayList<>();
        if (tryNumber == 0) {
            return winnerCars;
        }
        Collections.sort(raceCarList, Collections.reverseOrder());
        winnerCars.add(raceCarList.get(0));

        for (int i = 1; i < raceCarList.size(); i++) {
            if (winnerCars.get(0).compareTo(raceCarList.get(i)) != 0) {
                break;
            }
            winnerCars.add(raceCarList.get(i));
        }

        return winnerCars;
    }

    private void printWinners(ArrayList<Car> winnerCars) {
        System.out.print(GameData.MESSAGE_WINNERS);
        for(int i = 0; i < winnerCars.size() - 1; i++) {
            winnerCars.get(i).printName();
            System.out.print(", ");
        }
        winnerCars.get(winnerCars.size() - 1).printName();
        System.out.println();
    }

    public interface InputChecker {
        void checkCarName(String input);

        void checkTryNumber(String input);
    }
}
