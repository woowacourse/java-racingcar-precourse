package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class GameController {
    private final ArrayList<Car> carList = new ArrayList<>();

    public void gameStart() {
        InputRole inputRole = new InputRole();
        OutputRole outputRole = new OutputRole();
        inputRole.inputStart();
        changeInputToCar(inputRole);

        outputRole.pirntResultInstruction();
        for (int i=0; i<inputRole.getTrialNmber(); i++) {
            tryGameOnce();
            outputRole.printOneGame(carList);
        }


    }

    private void changeInputToCar(InputRole inputRole) {
        for (String name : inputRole.getNameList()) {
            this.carList.add(new Car(name));
        }
    }

    private int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    private boolean checkMoveForward(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    private void tryGameOnce(){
        for (Car car: carList) {
            int randomNumber = getRandomNumber();
            if (checkMoveForward(randomNumber)) {
                car.moveForward();
            }
        }
    }






}
