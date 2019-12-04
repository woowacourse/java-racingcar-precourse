import java.util.Arrays;

import controller.InputController;

public class RacingGame {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        System.out.println("게임을 시작합니다.");
        InputController inputController = new InputController();
        System.out.println(Arrays.toString(inputController.getNameOfCars()));
        System.out.println(inputController.getTimesToRun());
    }
}
