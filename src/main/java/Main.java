/**
 * Main 클래스는 게임을 진행하는 클래스로
 * 기본적으로 게임에 필요한 입력을 받는 메소드가 정리되어 있고,
 * GameFunction클래스와 Car클래스를 가져와 진행하는 클래스입니다.
 *
 * @author      양준혁
 */

import domain.Car;
import domain.GameFunction;

import java.util.Scanner;

import static domain.GameFunction.startRacingGame;

public class Main {
    public static String totalCarInput;
    public static String[] carList;
    public static Car[] cars;
    public static int numberOfCars;
    public static int raceCount;

    public static void main(String[] args) {
        inputCars();
        makeCars();
        inputRaceCount();
        startRacingGame(cars,raceCount);
    }
    public static void inputCars() {
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            totalCarInput = s.nextLine();
            carList = totalCarInput.split(",");
        } while (checkCarNameLength(carList));
        numberOfCars = carList.length;
    }
    public static void makeCars() {
        cars = new Car[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = new Car(carList[i]);
        }
    }
    public static boolean checkCarNameLength(String[] carList) {
        for (String car : carList) {
            if (car.length() > 5 || car.length() == 0) {
                return true;
            }
        }
        return false;
    }
    public static void inputRaceCount() {
        Scanner s = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        raceCount = s.nextInt();
    }
}
