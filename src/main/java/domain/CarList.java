package domain;

import java.util.ArrayList;
import java.util.Collections;

public class CarList {

    private static final int FIRST_WINNER_NUMBER = 0;       // 승자는 무조건 한 명이상이다. 그 때 첫 승자의 인덱스 값.
    private static ArrayList<Car> carList;

    public CarList() {
        this.carList = new CarNameCheck().splitCarName();
    }

    public static String lastWinners() {
        Collections.sort(carList, new CarComparator());
        String winnersNameList = carList.get(FIRST_WINNER_NUMBER).getName();
        for (int i = 1; i < howManyWin(); i ++) {
            winnersNameList += "," + carList.get(i).getName();
        }
        return winnersNameList;
    }

    private static int howManyWin() {
        int winnersNumber = 1;
        for(int i = 0; i < carList.size()-1; i ++) {
            if (!isSamePosition(carList.get(i), carList.get(i+1))) {
                break;
            }
            winnersNumber ++;
        }
        return winnersNumber;
    }

    private static boolean isSamePosition(Car carA, Car carB) {
        return (carA.getPosition() == carB.getPosition());
    }


}
