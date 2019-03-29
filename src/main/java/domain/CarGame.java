package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class CarGame {
    private ArrayList<Car> cars;
    private int runs;

    public CarGame() {
        printMessageRunNumbers();
        this.cars = getCarNames();

        printMessageCarNames();
        this.runs = getRunNumbers();
    }

    public int getRuns() {
        return runs;
    }

    private void printMessageCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private ArrayList<Car> getCarNames() {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.next().split(",");
        return makeCarListFromArray(tmp);
    }

    private ArrayList<Car> makeCarListFromArray(String[] carNames) {
        ArrayList<Car> carArrayList = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            carArrayList.add(tmpCar);
        }

        return carArrayList;
    }

    private int getRunNumbers() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void printMessageRunNumbers() {
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public void printResultEachGame() {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), car.getPosition());
        }
        System.out.println();
    }
}
