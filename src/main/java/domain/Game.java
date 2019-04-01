package domain;

import java.util.Scanner;

public class Game {

    String carName;
    String[] carNames;
    Car[] cars;
    int times;

    public void run() {
        do {
            InputCarName();
            SplitWithComma();
        }
        while (!CheckCarNameLength());
        createCar();
        InputTimes();
    }

    public void InputCarName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName = sc.nextLine();
    }

    public void SplitWithComma() {
        carNames = carName.split(",");
    }

    public boolean CheckCarNameLength() {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                System.out.println("자동차 이름을 5자리 이하로 입력해주세요.");
                return false;
            }
        }

        return true;
    }

    public void createCar() {
        cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void InputTimes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        times = sc.nextInt();
    }

    public int createRandomNumber() {
        int randomNumber = (int)Math.random() * 10;

        return randomNumber;
    }

    public boolean checkGoAndStop(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }
}
