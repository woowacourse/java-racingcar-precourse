package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class CarGame {
    private ArrayList<Car> cars;

    public CarGame() {
        String[] tmpCarNames = getCarNamesInput();
        this.cars = makeCarListFromArray(tmpCarNames);
    }

    private String[] getCarNamesInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return sc.next().split(",");
    }

    private ArrayList<Car> makeCarListFromArray(String[] carNames) {
        ArrayList<Car> carArrayList = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            carArrayList.add(tmpCar);
        }

        return carArrayList;
    }
}
