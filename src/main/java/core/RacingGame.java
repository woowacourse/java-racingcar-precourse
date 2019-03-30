package core;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private int round;
    private List<Car> carList;
    private Scanner scanner;

    public RacingGame() {
        scanner = new Scanner(System.in);
        carList = new ArrayList<>();
    }

    public void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String nameInput = scanner.next();
        scanner.nextLine();
        System.out.println("Input : " + nameInput);
        System.out.println("시도할 횟수는 몇회인가요?");
        round = scanner.nextInt();
    }

}
