import domain.Car;
import domain.GameFunction;

import java.util.Scanner;

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
        printCarList();

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

    public static void printCarList() {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.printf("%s : %s \n",car.getCarName(),car.printCarPosition());
        }
    }

    public static void inputRaceCount() {
        Scanner s = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        raceCount = s.nextInt();
    }
}
