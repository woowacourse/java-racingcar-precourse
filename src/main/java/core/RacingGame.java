package core;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int round;
    private List<Car> carList;
    private Scanner scanner;
    private Random random;

    public RacingGame() {
        scanner = new Scanner(System.in);
        carList = new ArrayList<>();
        random = new Random();
    }

    private boolean init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String nameInput = scanner.next();
        scanner.nextLine();
        String[] nameInputList = nameInput.split(",");
        for (String name : nameInputList) {
            Car car = new Car(name);
            carList.add(car);
        }
        System.out.println("시도할 횟수는 몇회인가요?");
        round = scanner.nextInt();
        System.out.println();

        return true;
    }

    private void playRounds() {
        for (Car car : carList) {
            if (random.nextInt(10) >= 4)
                car.goForward();
            car.printPosition();
        }
        System.out.println();
    }

    private void printWinner() {
        String winnerName = "";
        int winnerPosition = 0;

        for (Car car : carList) {
            if (car.getPosition() > winnerPosition) {
                winnerName = car.getName();
                winnerPosition = car.getPosition();
            } else if (car.getPosition() == winnerPosition)
                winnerName += ("," + car.getName());
        }

        System.out.println(winnerName + "가 최종 우승했습니다!");
    }

    private void finish() {
        scanner.close();
    }

    public boolean progressGame() {
        if (!init())
            return false;

        System.out.println("실행결과");
        System.out.println();
        for (int i = 0; i < round; i++)
            playRounds();

        printWinner();

        finish();

        return true;
    }
}
