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
        System.out.println(GameData.MESSAGE_ASK_CAR_NAMES);
        String[] carNames = readLine().split(",");

        for (String carName : carNames) {
            inputChecker.checkCarName(carName);
            addNewCar(carName);
        }
    }

    private void askTryNumber() {
        System.out.println(GameData.MESSAGE_ASK_TRY_NUMBER);
        String tryNumber = readLine();

        inputChecker.checkTryNumber(tryNumber);
        this.tryNumber = Integer.parseInt(tryNumber);
    }

    private void addNewCar(String carName) {
        //TODO: 자동차 추가 기능 구현
    }

    public interface InputChecker {
        public void checkCarName(String input);

        public void checkTryNumber(String input);
    }
}
