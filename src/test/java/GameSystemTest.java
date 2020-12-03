import java.util.Scanner;

import racingcar.GameSystem;

public class GameSystemTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        GameSystem game = new GameSystem();

        game.makeCars(scanner);
    }
}
