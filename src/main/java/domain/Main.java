package domain;

import java.util.*;

public class Main {

    private static OutputPrint outputPrint = new OutputPrint();
    private static InputScanner inputScanner = new InputScanner();
    private static CarList carList;

    public static void main(String[] args) {
        outputPrint.insertName();
        carList = new CarList();
        outputPrint.howManyTry();
        int gameSets = inputScanner.howManyPlay();
        outputPrint.executeResult();
        for (int i = 0; i < gameSets; i++) {
            play(carList);
        }

        outputPrint.finalWinner(carList.lastWinners());
    }

    private static void play(ArrayList<Car> carList) {
        for(int i = 0; i < carList.size(); i ++) {
            Car currentCar = carList.get(i);
            if (canDrive()) {
                currentCar.drive();
            }
            currentCar.printDistance();
            outputPrint.println("");
        }
        outputPrint.println("");
    }

}
