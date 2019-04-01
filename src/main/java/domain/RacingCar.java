package domain;

import java.util.Scanner;

public class RacingCar {
    public int maxPosition = 0;

    public static void main(String[] args) {
        RacingCar race = new RacingCar();
        race.play();
    }

    public void play() {
        String[] carNames = setCarNames();
        Car[] cars = makeCars(carNames);
        final int numOfGames = setNumOfGames();

        System.out.println("실행 결과");
        for (int i = 0; i < numOfGames; i++) {
            doGame(cars);
            System.out.println();
        }
        decideWinner(cars);
    }

    public String[] setCarNames() {
        Scanner scan = new Scanner(System.in);
        String[] carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String userInput = scan.nextLine();
            carNames = userInput.split(",");
        } while (!areValidNames(carNames));
        return carNames;
    }

    public boolean areValidNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public Car[] makeCars(String[] carNames) {
        int numOfCars = carNames.length;
        Car[] cars = new Car[numOfCars];
        for (int i = 0; i < numOfCars; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public int setNumOfGames() {
        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        int numOfGames = scan.nextInt();
        return numOfGames;
    }

    public void doGame(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].doRacing();
            cars[i].printPosition();
            if (cars[i].getPosition() > maxPosition) {
                maxPosition = cars[i].getPosition();
            }
        }
    }

    public void decideWinner(Car[] cars) {
        String printWinner = "";
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                printWinner += car.getName() + ", ";
            }
        }
        printWinner = printWinner.substring(0, printWinner.length() - 2);
        printWinner += "가 최종 우승했습니다.";
        System.out.println(printWinner);
    }
}