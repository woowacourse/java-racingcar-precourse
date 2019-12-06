package io;

import domain.Car;
import java.util.Scanner;
import java.util.ArrayList;

public class IoSystem {
    private Scanner sc;
    private int count;

    public IoSystem() {
        sc = new Scanner(System.in);
    }

    public int getCount(){
        return count;
    }
    public void printCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public String inputCarList() {
        return sc.nextLine();
    }

    public void inputCount() {
        this.count = sc.nextInt();
    }

    public void printResult() {
        System.out.println("실행결과");
    }

    public void printResultCars(ArrayList<Car> cars) {
        if (cars.size() > 1) {
            for (int i = 0; i < cars.size() - 1; i++) {
                System.out.print(cars.get(i).getName());
                System.out.print(", ");
            }
        }
        for (int i = cars.size() - 1; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName());
        }
        System.out.println("가 최종 우승했습니다.");
    }
}