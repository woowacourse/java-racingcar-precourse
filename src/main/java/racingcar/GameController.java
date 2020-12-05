package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class GameController {
    private Scanner scanner;
    private String[] names;
    private int move;
    private CarController carController;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void controlGame() {
        getInput();
        carController = new CarController(names);
        while (move-- > Constant.ZERO) {
            carController.makeMove();
        }
        getWinner();
    }

    private void getInput() {
        Input input = new Input(scanner);
        names = input.getCarNames();
        move = input.getMoveCount();
    }

    private void getWinner(){
        Car[] cars = carController.cars;
        StringBuilder winnerNames = new StringBuilder("최종 우승자 : ");
        Arrays.sort(cars);
        int maxMove = cars[0].getPosition();
        for(int i=Constant.ZERO; i<carController.carAmount; i++) {
            if (cars[i].getPosition() != maxMove) break;
            winnerNames.append(cars[i].getName());
        }
        System.out.println(winnerNames);
    }

}
