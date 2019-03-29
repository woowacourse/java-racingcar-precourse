package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String[] getCarNamesInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.next().split(",");
    }

    public static ArrayList<Car> makeCarListFromArray(String[] carNames) {
        ArrayList<Car> carArrayList = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            carArrayList.add(tmpCar);
        }

        return carArrayList;
    }
    public static void main(String[] args) {
        String[] carNmaes = getCarNamesInput();
        ArrayList<Car> carArrayList = makeCarListFromArray(carNmaes);

        // car name 확인용
        for (Car car : carArrayList) {
            System.out.println(car.getName());
        }
    }
}
