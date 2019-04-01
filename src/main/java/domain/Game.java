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

        System.out.println("실행 결과");
        while (times-- > 0) {
            for (int i = 0; i < cars.length; i++) {
                oneGame(cars[i]);
            }
            System.out.println();
        }

        printWinner(maxPosition());
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
        int randomNumber = (int)(Math.random() * 10);

        return randomNumber;
    }

    public boolean checkGoAndStop(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }

    public void increasePosition(Car car) {
        car.increasePosition();
    }

    public void printCarNameAndStatus(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getCarName());
        sb.append(":");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }

        System.out.println(sb);
    }

    public void oneGame(Car car) {
        if (checkGoAndStop(createRandomNumber())) {
            increasePosition(car);
        }
        printCarNameAndStatus(car);
    }

    public int maxPosition() {
        int max = 0;

        for (int i = 0; i < cars.length; i++) {
            if (max < cars[i].getPosition()) {
                max = cars[i].getPosition();
            }
        }

        return max;
    }

    public void printWinner(int max) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cars.length; i++) {
            if (max == cars[i].getPosition()) {
                sb.append(cars[i].getCarName() + ", ");
            }
        }

        if (sb.lastIndexOf(",") != -1) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }

        sb.append("가 최종 우승했습니다.");

        System.out.println(sb);
    }
}
