package woowacourse.racingcar;

import java.util.Scanner;

import domain.Car;

public class RacingCarGame {
    private Car [] car;
    private Scanner sc = new Scanner(System.in);

    public void runGame() {
        String [] carNames = this.getCarNames();
        int tryNumber = this.getTryNumber();
        this.setCarNames(carNames);
        this.startRacing(carNames, tryNumber);
        this.winnerPrint();
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
        car = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            car[i] = new Car(carNames[i]);
        }
    }

    private void startRacing(String [] names, int tryNumber) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < names.length; j++) {
                car[j].goAndStop();
                car[j].printResult();
            }
            System.out.println();
        }
    }

    private void winnerPrint() {
        int maxNumber = this.getMaxNumber();
        StringBuilder winner = this.checkWinner(maxNumber);
        System.out.printf("%s가 최종 우승했습니다.", winner);
    }

    private int getMaxNumber() {
        int maxNumber = Integer.MIN_VALUE;
        for (Car value : car) {
            if (maxNumber < value.getPosition()) {
                maxNumber = value.getPosition();
            }
        }
        return maxNumber;
    }

    private StringBuilder checkWinner(int maxNumber) {
        StringBuilder saveWinner = new StringBuilder();
        for (Car value : car) {
            if (value.getPosition() == maxNumber) {
                saveWinner.append(value.getName()).append(", ");
            }
        }
        saveWinner = new StringBuilder(saveWinner.substring(0, saveWinner.length() - 2));
        return saveWinner;
    }
}
