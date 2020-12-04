package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Player player = new Player(scanner);
        Race race = new Race(player);
        
        race.setUp();
    }
}
