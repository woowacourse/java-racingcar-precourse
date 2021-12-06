package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class GameController {

    private static final int MAX_PICK_NUMBER = 9;
    private static final int MIN_PICK_NUMBER = 0;
    private static final int MOVE_FORWARD_CONTION_NUMBER = 0;
    private final ArrayList<Car> carList = new ArrayList<>();
    private final ArrayList<String> winnersList = new ArrayList<>();

    public void gameStart() {
        InputRole inputRole = new InputRole();
        OutputRole outputRole = new OutputRole();
        inputRole.inputStart();
        changeInputToCar(inputRole);

        outputRole.pirntResultInstruction();
        for (int i = 0; i < inputRole.getTrialNmber(); i++) {
            tryGameOnce();
            outputRole.printOneGame(carList);
        }
        findWinner();
        outputRole.printWinner(winnersList);
    }

    private void changeInputToCar(InputRole inputRole) {
        for (String name : inputRole.getNameList()) {
            this.carList.add(new Car(name));
        }
    }

    private int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
        return randomNumber;
    }

    private boolean checkMoveForward(int randomNumber) {
        return randomNumber >= MOVE_FORWARD_CONTION_NUMBER;
    }

    private void tryGameOnce() {
        for (Car car : carList) {
            int randomNumber = getRandomNumber();
            if (checkMoveForward(randomNumber)) {
                car.moveForward();
            }
        }
    }

    private void findWinner() {
        int maxValue = findMaxInCarList(carList);
        for (Car car : carList) {
            if (car.getPosition() == maxValue) {
                winnersList.add(car.getName());
            }
        }
    }

    private int findMaxInCarList(ArrayList<Car> carList) {
        int maxValue = -1;
        for (Car car : carList) {
            if (maxValue < car.getPosition()) {
                maxValue = car.getPosition();
            }
        }
        return maxValue;
    }
}
