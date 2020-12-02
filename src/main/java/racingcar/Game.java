package racingcar;

import java.util.Scanner;

/**
 * 게임이 진행되는 클래스
 */
public class Game {

    private final Scanner scanner;
    private final InputGuide inputGuide;

    Game(Scanner scanner){
        this.scanner = scanner;
        this.inputGuide = new InputGuide(scanner);
    }

    public void play(){
        inputGuide.inputCars();
    }

}
