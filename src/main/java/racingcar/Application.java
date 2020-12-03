package racingcar;

import controller.CarController;
import preprocess.InputPreProcess;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        InputPreProcess input = new InputPreProcess();
        CarController controller = new CarController();

        GameBoard board = new GameBoard(input, controller);


        // 이름을 받는다, 안될 경우 계속 받아준다.
        String line = scanner.nextLine();
        while (!board.getNames(line)) {
            line = scanner.nextLine();
        }

        // 시도할 횟수를 받는다, 안될 경우 계속 받아준다.
        String lap = scanner.nextLine();
        while(!board.startRace(lap)) {
            lap = scanner.nextLine();
        }

    }
}
