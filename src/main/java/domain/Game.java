package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    static final int standardRandomNum = 4;
    static final int nameCharLimit = 5;
    String winnerList = "";
    int movingNum;
    String[] carName;
    Car[] car;
    Scanner sc = new Scanner(System.in);

    public void run() {
        inputCarName();
        car = new Car[carName.length];
        inputMovingNum();
        System.out.println();
        createCar();
        playGame();
    }

    private void inputCarName() {
        String totalInputName;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 기준으로 구분) : ");
        totalInputName = sc.next();
        carName = totalInputName.split(",");
        if (!checkFormAboutName()) {
            inputCarName();
        }
    }

    private boolean checkFormAboutName() {
        for (int i = 0; i < carName.length; i++) {
            if (carName[i].length() > nameCharLimit) {
                System.out.println("5글자 내로 입력해주세요.");
                return false;
            }
            if (!checkSameName(i)) {
                System.out.println("중복되는 이름이 있습니다. 다시 입력해주세요.");
                return false;
            }
        }
        return true;
    }

    private boolean checkSameName(int i) {
        for (int j = 0; j < i; j++) {
            if (Objects.equals(carName[i], carName[j])) {
                return false;
            }
        }
        return true;
    }

    private void inputMovingNum() {
        System.out.println("시도할 횟수는 몇회인가요?");
        movingNum = sc.nextInt();
        if (!checkInputFormAboutMovingNum(movingNum)) {
            inputMovingNum();
        }
    }

    private boolean checkInputFormAboutMovingNum(int num) {
        if (num <= 0) {
            System.out.println("1이상의 수를 입력해주세요.");
            return false;
        }
        return true;
    }

    private void createCar() {
        for (int i = 0; i < carName.length; i++) {
            car[i] = new Car(carName[i]);
        }
    }

    private void playGame() {
        int[] randomNum = new int[carName.length];
        for (int i = 0; i < movingNum; i++) {
            makeRandomNumber(randomNum);
            advanceAccordingToARandomNum(randomNum);
            if (i == 0) {
                System.out.println("실행 결과");
            }
            showCurrScore();
        }
        findWinner();
        printWinner();
    }

    private void makeRandomNumber(int[] randomNum) {
        for (int i = 0; i < carName.length; i++) {
            randomNum[i] = (int) (Math.random() * 10);
        }
    }

    private void advanceAccordingToARandomNum(int[] randomNum) {
        for (int i = 0; i < carName.length; i++) {
            if (randomNum[i] >= standardRandomNum) {
                car[i].addPosition();
            }
        }
    }

    private void showCurrScore() {
        for (int i = 0; i < carName.length; i++) {
            System.out.print(car[i].getName() + " : ");
            for (int j = 0; j < car[i].currPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void findWinner() {
        int max = -1;

        for (int i = 0; i < carName.length; i++) {
            if (max < car[i].currPosition()) {
                max = car[i].currPosition();
                winnerList = "";
                winnerList += car[i].getName();
                continue;
            }
            if (max == car[i].currPosition()) {
                winnerList += ", " + car[i].getName();
            }
        }
    }

    private void printWinner() {
        System.out.println(winnerList + "가 최종 우승했습니다.");
    }
}
