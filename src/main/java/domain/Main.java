package domain;

import java.util.*;

public class Main {

    private static final int INIT_NUMBER = 0;       // 5번의 게임세트가 있다면, 그 세트의 첫 번째 세트를 가리킨다.
    private static OutputPrint outputPrint = new OutputPrint();
    private static InputScanner inputScanner = new InputScanner();
    private static CarList carList;

    public static void main(String[] args) {
        outputPrint.insertName();
        carList = new CarList();
        outputPrint.howManyTry();
        int gameSets = inputScanner.howManyPlay();
        outputPrint.executeResult();
        carList.play(INIT_NUMBER);

        outputPrint.finalWinner(carList.lastWinners());
    }

}
