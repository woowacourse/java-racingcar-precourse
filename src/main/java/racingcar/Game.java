package racingcar;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {

    private Scanner scanner;
    private Car[] cars;
    private int round;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        initParams();
    }

    private void initParams() {
        initCars();
        initRound();
    }

    private void initCars() {
        String line = scanner.nextLine();
        String[] names = parseCarNames(line);
        createCars(names);
    }

    private String[] parseCarNames(String line) {
        StringTokenizer tk = new StringTokenizer(line, ",");
        String[] names = new String[tk.countTokens()];
        int i = 0;
        while (tk.hasMoreTokens())
            names[i++] = tk.nextToken();
        return names;
    }

    private void createCars(String[] names) {
        cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    private void initRound() {
        round = scanner.nextInt();
    }
}
