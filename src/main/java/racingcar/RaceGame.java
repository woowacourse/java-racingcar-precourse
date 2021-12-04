package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.*;

public class RaceGame {
    private InputChecker inputChecker;
    private ArrayList<Car> carArrayList;

    private int tryNumber;

    public RaceGame(InputChecker inputChecker) {
        this.inputChecker = inputChecker;
    }

    public void startGame() {
        askCarNames();
        askTryNumber();
    }

    private void askCarNames() {
        try {
            System.out.println(GameData.MESSAGE_ASK_CAR_NAMES);
            String[] carNames = readLine().split(",");

            for (String carName : carNames) {
                inputChecker.checkCarName(carName);
                addNewCar(carName);
            }
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

    private void addNewCar(String carName) {
        //TODO: 자동차 추가 기능 구현
    }

    public interface InputChecker {
        void checkCarName(String input);

        void checkTryNumber(String input);
    }
}
