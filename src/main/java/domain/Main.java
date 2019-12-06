package domain;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static private ArrayList<Car> cars;
    static private int turns;
    static private Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        cars = new ArrayList<>();

        boolean pass = makeCars();
        if (!pass) {
            System.out.println("정상적이지 않은 이름이 확인되었습니다. 게임을 종료합니다.");
            return;
        }

        setTurnsCount();
        if (turns < 1) {
            System.out.println("정상적이지 않은 회수가 확인되었습니다. 게임을 종료합니다.");
            return;
        }

        play();

        showResult();
    }

    static private boolean makeCars() {
        String allCarsName;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        System.out.println("각 자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        allCarsName = sc.nextLine();
        String[] splittedNames = allCarsName.split(",");
        for (String name : splittedNames) {
            boolean validName = validateName(name);
            if (!validName) return false;
            addNewCarToArray(cars, name);
        }
        return true;
    }

    static private boolean validateName(String name) {
        return (name.length() > 0 && name.length() <= 5);
    }

    static private void addNewCarToArray(ArrayList<Car> cars, String name) {
        Car car = new Car(name);
        cars.add(car);
    }


    static private void setTurnsCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        turns = sc.nextInt();
    }

    static private void play() {
        System.out.println("실행 결과");
        while (turns > 0) {
            turnOnEachCars();
            System.out.println();
            turns -= 1;
        }
    }

    static private void turnOnEachCars() {
        for (Car car : cars) {
            car.useTurn();
        }
    }

    static private void showResult() {
    }

}
