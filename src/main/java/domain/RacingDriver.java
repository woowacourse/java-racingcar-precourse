package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class RacingDriver {
    static int nTurns;
    static ArrayList<Car> cars;

    public static getWinners() {

    }

    public static String getCarNames() {
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)");

        return scan.nextLine();
    }

    public static String[] parseCarNames(String carsString) {
        String cars[] = carsString.split(",");

        for (int i = 0; i < cars.length; i++) {
            cars[i] = cars[i].trim();
        }

        return cars;
    }

    public static void makeCars(String[] carsStr) {
        cars = new ArrayList<>();

        for (String carName: carsStr) {
            cars.add(new Car(carName));
        }
    }

    public static void getTurns() {
        Scanner scan = new Scanner(System.in);

        System.out.println("시도할 회수는 몇회인가요?");

        nTurns = scan.nextInt();
    }

    public static void printRaceStatus() {
        for (Car car: cars) {
            String status = car.getName() + " : " + String.format("%0" + car.getPosition() + "d", 0).replace("0", "-");
            System.out.println(status);
        }

        System.out.println("");
    }

    public static void doRace() {
        System.out.println("실행결과");

        for (int i = 0; i < nTurns; i++) {
            for (Car car: cars) {
                car.proceed();
            }
            printRaceStatus();
        }
    }

    public  static void main(String args[]) {

    }
}
