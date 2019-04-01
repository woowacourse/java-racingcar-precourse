package domain;

import java.util.Scanner;

public class PlayGame {
    private String inputString;
    private int inputNum;
    private String[] arr;
    private Car[] cars;

    private void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분");
        this.inputString = sc.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        this.inputNum = sc.nextInt();
    }

    private void splitString() {
        this.arr = inputString.split(",");
    }

    private void setCars() {
        cars = new Car[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cars[i] = new Car(arr[i]);
        }
    }

    private void oneTimeRace() {
        for (int i = 0; i < arr.length; i++) {
            cars[i].race();
        }
        System.out.println();
    }
}
