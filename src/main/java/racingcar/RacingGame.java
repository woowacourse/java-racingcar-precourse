package racingcar;

import java.util.Scanner;

public class RacingGame {
    private Scanner scanner;
    private Car[] cars;
    private String[] names;
    private int move;
    private int carAmount;

    public RacingGame(Scanner scanner) {
        this.scanner = scanner;
    }

    public void playingGame() {
        getInput();
        makeCarInstance(names);
        System.out.println("실행 결과");
        while (move-- > 0) {
            for(int i=0; i<carAmount; i++){
                cars[i].move();
                cars[i].print();
            }
            System.out.println();
        }
    }

    private void makeCarInstance(String[] names) {
        for (int i = 0; i < carAmount; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    private void getInput() {
        Input input = new Input(scanner);
        names = input.getCarNames();
        move = input.getMoveCount();
        carAmount = names.length;
        cars = new Car[carAmount];
    }
}
