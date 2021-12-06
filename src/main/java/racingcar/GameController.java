package racingcar;

import java.util.ArrayList;

public class GameController {

    private ArrayList<Car> carList;

    public void gameStart() {
        InputRole inputRole = new InputRole();
        inputRole.inputStart();
        changeInputToCar(inputRole);

    }

    private void changeInputToCar(InputRole inputRole) {
        for (String name : inputRole.getNameList()) {
            carList.add(new Car(name));
        }
    }



}
