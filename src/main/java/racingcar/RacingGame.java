package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class RacingGame {
    Scanner scanner;

    public RacingGame(Scanner scanner){
        this.scanner = scanner;
    }

    public void startGame(){
        Input input = new Input(scanner);
        String[] names = input.getCarNames();
        int move = input.getMoveCount();
//        System.out.println(Arrays.toString(names) + " " + move);
    }
}
