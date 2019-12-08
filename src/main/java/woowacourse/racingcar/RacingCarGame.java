package woowacourse.racingcar;

import java.util.Scanner;

import domain.Car;

public class RacingCarGame {
    private Car [] cars;
    private Scanner sc = new Scanner(System.in);

    public void runGame() {
        boolean checkInput = false;
        while (!checkInput) {
            String [] carNames = this.getCarNames();
            this.setCarNames(carNames);
            checkInput = this.checkInput();
            if (!checkInput) {
                System.out.println("다시 입력해주세요. 이름은 최대 5자까지 가능합니다.");
            }
        }
        int tryNumber = this.getTryNumber();
        this.startRacing(tryNumber);
        this.winnerPrint();
    }

    private boolean checkInput() {
        for (Car value : cars) {
            if (value.getName().length() > 5) {
                return false;
            }
        }
        return true;
    }

    private String [] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.nextLine().split(",");
    }

    private int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    private void setCarNames(String [] carNames) {
        int carCount = carNames.length;
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    private void startRacing(int tryNumber) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            for (Car value : cars) {
                value.goAndStop();
                value.printResult();
            }
            System.out.println();
        }
    }

    private void winnerPrint() {
        int maxNumber = this.getMaxNumber();
        StringBuilder winner = this.checkWinner(maxNumber);
        System.out.println(""+winner+"가 최종 우승했습니다.");
    }

    private int getMaxNumber() {
        int maxNumber = Integer.MIN_VALUE;
        for (Car value : cars) {
            if (maxNumber < value.getPosition()) {
                maxNumber = value.getPosition();
            }
        }
        return maxNumber;
    }

    private StringBuilder checkWinner(int maxNumber) {
        StringBuilder saveWinner = new StringBuilder();
        for (Car value : cars) {
            if (value.getPosition() == maxNumber) {
                saveWinner.append(value.getName()).append(", ");
            }
        }
        saveWinner = new StringBuilder(saveWinner.substring(0, saveWinner.length() - 2));
        return saveWinner;
    }
}
