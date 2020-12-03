import java.util.Scanner;

import racingcar.Car;
import racingcar.GameSystem;

public class GameSystemTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameSystem game = new GameSystem();

        game.makeCars(scanner);
        Car[] cars = game.getCars();

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].getName());
        }
    }
}
