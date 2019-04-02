package domain;

import java.util.ArrayList;

public class RaceingGameController {

    public void gameStart() {

        System.out.println(Output.outputEnrollCarName);
        ArrayList<Car> carNameList = Input.getInstance().enrollCarName();

        System.out.println(Output.outputTryNumber);
        int tryNumber = Input.getInstance().tryNumber();

        System.out.println();
        gameResult(carNameList, tryNumber);

    }

    private void gameResult(ArrayList<Car> carNameList, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            racingStart(carNameList);
            System.out.println();
        }

        System.out.println(Output.getInstance().gameRusultMessage(carNameList).toString() + Output.outputResult);
    }

    private void racingStart(ArrayList<Car> carNameList) {
        for (Car car : carNameList) {
            car.movePosition();
            Output.getInstance().gameOngoingMessage(car);
        }
    }

}
