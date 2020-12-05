package racingcar;

import java.util.Scanner;

public class GameController {
    private Scanner scanner;
    private Car[] cars;
    private String[] names;
    private int move;
    private int carAmount;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void controlGame() {
        getInput();
        makeCarInstance(names);
        makeMove();
        getWinner();
    }

    private void getInput() {
        Input input = new Input(scanner);
        names = input.getCarNames();
        move = input.getMoveCount();
        carAmount = names.length;
        cars = new Car[carAmount];
    }

    private void makeCarInstance(String[] names) {
        for (int i = 0; i < carAmount; i++) {
            cars[i] = new Car(names[i]);
        }
    }

    private void makeMove(){
        System.out.println("실행 결과");
        while (move-- > 0) {
            for(int i=0; i<carAmount; i++){
                cars[i].move();
                cars[i].print();
            }
            System.out.println();
        }
    }

    private void getWinner(){
        int maxMove = 0;
        for(int i=0; i<carAmount; i++){
            maxMove = Math.max(maxMove, cars[i].getPosition());
        }

    }
}
