package View;

import racingcar.Cars;

public class OutputView {

    public OutputView() {

    }

    public static void printCurrentStatus(String carName, int position) {
        String currentPosition = "";
        for(int i = 0; i<position; i++) {
            currentPosition += "-";
        }
        System.out.println(carName + " : " + currentPosition);
    }

}
