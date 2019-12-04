package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;

public class InputController {
    private Scanner scanner;

    public InputController() {
        this.scanner = new Scanner(System.in);
    }

    public List<Car> getNameOfCars() {
        List<Car> cars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = this.scanner.nextLine();
        //    TODO: 예외 처리
        String[] carNames = userInput.split(",");
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getTimesToRun() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = this.scanner.nextLine();
        //    TODO: 예외 처리
        return Integer.parseInt(userInput);
    }
}
