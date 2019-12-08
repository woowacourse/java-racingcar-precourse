package domain;

import java.util.Scanner;

public class Game {
    static final int standardRandomNum = 4;
    String[] carName;
    Car[] car;
    String winnerList = "";
    int movingNum;
    Scanner sc = new Scanner(System.in);

    public void run() {
        inputCarName();
        car = new Car[carName.length];
        inputMovingNum();
        createCar();
        playGame();
    }

    private void inputCarName() {
        String totalInputName;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표 기준으로 구분) : ");
        totalInputName = sc.next();
        carName = totalInputName.split(",");
        if (!checkFormAboutName()) {
            System.out.println("5글자 내로 입력해주세요.");
            inputCarName();
        }
    }

    private boolean checkFormAboutName() {
        for (int i = 0; i < carName.length; i++) {
            if (carName[i].length() > 5) {
                return false;
            }
        }
        return true;
    }

    private void inputMovingNum() {
        System.out.println("시도할 횟수는 몇회인가요?");
        movingNum = sc.nextInt();
        System.out.println();
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
        int max = car[0].currPosition();

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
