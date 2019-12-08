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
            carList.play();
        }

        outputPrint.finalWinner(carList.lastWinners());
    }

}
