/**
 * 클래스 이름       Game
 * 버전 정보        1.0
 * 날짜            2019.12.10
 * 저작권          joi0104
 */

package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final ArrayList<Car> carList = new ArrayList<Car>();
    private int tryCount;

    public void playGame() {
        initializeGame();
        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            moveAndPrintEachCar();
            System.out.println();
        }
        printWinnerName();
    }

    private void initializeGame() {
        getCarList();
        getTryCount();
    }

    private void getCarList() {
        String[] carNameList;
        do {
            carNameList = getCarNameList();
        } while (!checkNameList(carNameList));
        makeCarList(carNameList);
    }

    private String[] getCarNameList() {
        Scanner scanner = new Scanner(System.in);
        String[] carNameList;
        System.out.println("경주할 자동차 이름 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameList = scanner.nextLine().split(",");
        return carNameList;
    }

    private boolean checkNameList(String[] carNameList) {
        for (String name : carNameList) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                System.out.println("차 이름은 5자 이하여야 합니다.");
                return false;
            }
        }
        return true;
    }

    private void makeCarList(String[] carNameList) {
        for (String name : carNameList) {
            carList.add(new Car(name));
        }
    }

    private void getTryCount() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            tryCount = scanner.nextInt();
        } while (!checkTryCount(tryCount));
    }

    private boolean checkTryCount(int tryCount) {
        Object tryCountObject = tryCount;
        if (tryCountObject instanceof Integer) {
            return true;
        }
        System.out.println("시도할 회수는 숫자이어야 합니다.");
        return false;
    }

    private void moveAndPrintEachCar() {
        for (Car car : carList) {
            car.moveForward();
            car.printPosition();
        }
    }

    private void printWinnerName() {
        ArrayList<String> winnerNameList = getWinnerName();
        int winnerNameListLength = winnerNameList.size();
        for (int i = 0; i < winnerNameListLength - 1; i++) {
            System.out.print(winnerNameList.get(i) + ",");
        }
        System.out.println(winnerNameList.get(winnerNameListLength - 1) + "가 최종우승 했습니다.");
    }

    private ArrayList<String> getWinnerName() {
        ArrayList<String> winnerNameList = new ArrayList<String>();
        int maxPositon = findMaxPosition();
        for (Car car : carList) {
            if (car.getPosition() == maxPositon) {
                winnerNameList.add(car.getName());
            }
        }
        return winnerNameList;
    }

    private int findMaxPosition() {
        ArrayList<Integer> carPositionList = new ArrayList<Integer>();
        for (Car car : carList) {
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }
}