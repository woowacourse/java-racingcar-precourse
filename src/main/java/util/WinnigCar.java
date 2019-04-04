package util;

import domain.Car;

import java.util.ArrayList;

public class WinnigCar {
    static ArrayList<String> winnerNameList = new ArrayList<String>();
    private static final String FINAL_WIN = "가 최종 우승했습니다.";

    /**
     * 우승자를 찾고 출력
     */
    public static void getWinner() {
        int maxNum = getMaxNum(MakeCar.carArray);
        getWinnerName(MakeCar.carArray, maxNum);
        printWinner();
    }

    /**
     * 가장 많이 전진한 차의 전진 횟수
     *
     * @param cars
     * @return 최대값
     */
    public static int getMaxNum(ArrayList<Car> cars) {
        int maxNum = cars.get(0).getPosition();
        for (int i = 1; i < cars.size(); i++) {
            if (maxNum < cars.get(i).getPosition()) {
                maxNum = cars.get(i).getPosition();
            }
        }
        return maxNum;
    }

    /**
     * 최대 횟수와 동일한 횟수로 전진한 차의 이름을 리스트에 저장
     *
     * @param cars
     * @param maxNum
     */

    public static void getWinnerName(ArrayList<Car> cars, int maxNum) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == maxNum) {
                winnerNameList.add(cars.get(i).getName());
            }
        }
    }

    /**
     * 우승자를 출력하는 함수
     */
    public static void printWinner() {
        int winnerSize = winnerNameList.size();
        for (int i = 0; i < winnerSize - 1; i++) {
            System.out.print(winnerNameList.get(i) + ", ");
        }
        //마지막 출력 우승자 뒤에는 ',' 이 붙지 않도록 따로 출력
        System.out.println(winnerNameList.get(winnerSize - 1) + FINAL_WIN);
    }
}
