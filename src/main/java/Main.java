import domain.Car;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<Car> cars = new ArrayList();
        for (String name : sc.next().split(",")) {
            cars.add(new Car(name, new Random()));
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int trials = sc.nextInt();

        RacingGame game = new RacingGame(cars, trials);
        game.play(new RacingTrial(), new ScoreBoard());
    }
}
