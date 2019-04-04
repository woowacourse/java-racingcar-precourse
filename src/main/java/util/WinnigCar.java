package util;

import domain.Car;

import java.util.ArrayList;

public class WinnigCar {
    static ArrayList<String> winnerNameList = new ArrayList<String>();
    private static final String FINAL_WIN = "가 최종 우승했습니다.";

    public static void getWinner() {
        int maxNum = getMaxNum(MakeCar.carArray);
        getWinnerName(MakeCar.carArray, maxNum);
        printWinner();
    }

    public static int getMaxNum(ArrayList<Car> cars) {
        int maxNum = cars.get(0).getPosition();
        for (int i = 1; i < cars.size(); i++) {
            if (maxNum < cars.get(i).getPosition()) {
                maxNum = cars.get(i).getPosition();
            }
        }
        return maxNum;
    }

    public static void getWinnerName(ArrayList<Car> cars, int maxNum) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == maxNum) {
                winnerNameList.add(cars.get(i).getName());
            }
        }
    }

    public static void printWinner() {
        int winnerSize = winnerNameList.size();
        for (int i = 0; i < winnerSize - 1; i++) {
            System.out.print(winnerNameList.get(i) + ", ");
        }
        System.out.println(winnerNameList.get(winnerSize - 1) + FINAL_WIN);
    }

}
