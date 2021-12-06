package racingcar;

import java.util.ArrayList;

public class GameController {
    private final ArrayList<Car> carList = new ArrayList<>();

    public void gameStart() {
        InputRole inputRole = new InputRole();
        inputRole.inputStart();
        changeInputToCar(inputRole);

    }

    private void changeInputToCar(InputRole inputRole) {
        for (String name : inputRole.getNameList()) {
            this.carList.add(new Car(name));
        }
    }






}
