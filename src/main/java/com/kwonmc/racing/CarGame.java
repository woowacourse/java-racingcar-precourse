package com.kwonmc.racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CarGame {
    private static final int INT_ZERO = 0;

    private List<Car> cars;
    private int runs;

    public CarGame() {
        printMessageCarNames();
        this.cars = getCarNames();

        printMessageRunNumbers();
        this.runs = getRunNumbers();
    }

    public int getRuns() {
        return runs;
    }

    private void printMessageCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private ArrayList<Car> getCarNames() {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.next().split(",");
        return makeCarListFromArray(tmp);
    }

    private ArrayList<Car> makeCarListFromArray(String[] carNames) {
        ArrayList<Car> carArrayList = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            carArrayList.add(tmpCar);
        }

        return carArrayList;
    }

    private int getRunNumbers() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void printMessageRunNumbers() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public void runEachGame() {
        for (Car car : cars) {
            car.moveByRandomNumber();
        }
    }

    public void printResultEachGame() {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), car.getStringPosition());
        }
        System.out.println();
    }

    private String arrayToStringJoin(String[] arr, String delimiter) {
        StringBuilder builder = new StringBuilder();

        int lastIndex = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);

            if (i != lastIndex) {
                builder.append(delimiter);
            }
        }

        return builder.toString();
    }

    private int countElementNumber(int number) {
        int result = INT_ZERO;
        for (Car car : this.cars) {
            if (car.getPosition() == number) {
                result++;
            }
        }
        return result;
    }

    private String[] getWinnerArray() {
        int maxPosition = Collections.max(this.cars).getPosition();
        String[] result = new String[countElementNumber(maxPosition)];

        int index = INT_ZERO;
        for (Car car : this.cars) {
            if (car.getPosition() == maxPosition) {
                result[index] = car.getName();
                index++;
            }
        }

        return result;
    }

    public void printResultTotal() {
        String[] resultArray = getWinnerArray();
        String result = arrayToStringJoin(resultArray, ", ");
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
