package domain;

import java.util.*;

public class Main {

    private static final int RANDOM_MAX_NUMBER = 10;        // 차가 전진할 수 있을지 결정될 때, 랜덤으로 나올 수 있는 수들의 최대 크기.
    private static final int RANDOM_PARTITION_NUMBER = 4;   // 4보다 큰 수가 나오면 차는 전진할 수 있다. 그래서 전진할 지 말지 나누는 기준이 되는 수.

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

    public static boolean canDrive() {
        Random random = new Random();
        return (random.nextInt(RANDOM_MAX_NUMBER) >= RANDOM_PARTITION_NUMBER);
    }

}
