package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RacingDriver {
    private static int nTurns;
    private static ArrayList<Car> cars;

    private static String getCarNames() {
        Scanner scan = new Scanner(System.in);

        return scan.nextLine();
    }

    private static String[] parseCarNames(String carsString) {
        String[] cars = carsString.split(",");

        for (int i = 0; i < cars.length; i++) {
            cars[i] = cars[i].trim();
        }

        return cars;
    }

    private static void makeCars(String[] carsStr) {
        cars = new ArrayList<>();

        for (String carName: carsStr) {
            cars.add(new Car(carName));
        }
    }

    private static void getTurns() {
        Scanner scan = new Scanner(System.in);

        nTurns = scan.nextInt();
    }

    private static void printRaceStatus() {
        for (Car car: cars) {
            String status = car.getName() + " : " + String.join("", Collections.nCopies(car.getPosition(), "-"));
            System.out.println(status);
        }

        System.out.println("");
    }

    private static void doRace() {
        for (int i = 0; i < nTurns; i++) {
            for (Car car: cars) {
                car.proceed();
            }
            printRaceStatus();
        }
    }

    private static String[] getWinners() {
        int max = 0;
        ArrayList<String> result = new ArrayList<>();

        for (Car car: cars) {
            max = Math.max(max, car.getPosition());
        }

        for (Car car: cars) {
            if (max == car.getPosition()) {
                result.add(car.getName());
            }
        }

        return result.toArray(new String[0]);
    }

    public  static void main(String[] args) {
        String[] carNames;

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)");

        carNames = parseCarNames(getCarNames());
        makeCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        getTurns();

        System.out.println("실행결과");
        doRace();

        System.out.println(String.join(",", getWinners()) + "가 최종 우승했습니다.");
    }
}
