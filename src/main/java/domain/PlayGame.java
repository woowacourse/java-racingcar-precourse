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

    private boolean nameLengthCheak() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= 5) {
                System.out.println("이름이 5자 초과인 자동차가 존재합니다.");
                return true;
            }
        }
        return false;
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

    private int getMaxIndex() {
        int max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < cars[i].getPosition()) {
                max = cars[i].getPosition();
                index = i;
            }
        }
        return index;
    }

    private void findWinner() {
        int max = getMaxIndex();
        int winnersNumber = 0;
        int[] winner = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (cars[max].getPosition() == cars[i].getPosition()) {
                winner[i] = 1;
                winnersNumber++;
            }
        }
        winnerOutput(winner, winnersNumber);
    }

    private void winnerOutput(int[] winner, int winnersNumber) {
        int winnersCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (winner[i] == 1) {
                System.out.print(cars[i].getName());
                winnersCount++;
            }
            if ((winner[i] == 1) && (winnersCount < winnersNumber)) {
                System.out.print(", ");
            }
        }
        System.out.println("가 최종 우승했습니다.");
    }

}
