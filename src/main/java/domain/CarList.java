package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CarList {

    private static final int RANDOM_MAX_NUMBER = 10;        // 차가 전진할 수 있을지 결정될 때, 랜덤으로 나올 수 있는 수들의 최대 크기.
    private static final int RANDOM_PARTITION_NUMBER = 4;   // 4보다 큰 수가 나오면 차는 전진할 수 있다. 그래서 전진할 지 말지 나누는 기준이 되는 수.
    private static final int FIRST_WINNER_NUMBER = 0;       // 승자는 무조건 한 명이상이다. 그 때 첫 승자의 인덱스 값.
    private static ArrayList<Car> carList;

    public CarList() {
        this.carList = new CarNameCheck().splitCarName();
    }

    public void play() {
        for(int i = 0; i < carList.size(); i ++) {
            Car currentCar = carList.get(i);
            if (canDrive()) {
                currentCar.drive();
            }
            currentCar.printDistance();
            new OutputPrint().println("");
        }
        new OutputPrint().println("");
    }

    private static boolean canDrive() {
        Random random = new Random();
        return (random.nextInt(RANDOM_MAX_NUMBER) >= RANDOM_PARTITION_NUMBER);
    }

    public String lastWinners() {
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
