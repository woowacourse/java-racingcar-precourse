package racingcar;

import domain.InputCarName;
import domain.Trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public Game() {

    }

    public static void gameRun(Scanner scanner) {
        String names = InputCarName.inputCarName(scanner);
        int trial = Trial.inputCountValidate(scanner);

        ArrayList<String> carnames = new ArrayList<>(Arrays.asList(names.split(",")));
        Cars cars = new Cars(carnames);


        System.out.println("\n실행 결과");
        for (int i = 0; i < trial; i++) {
            cars.moveCars();
            System.out.println(cars.getCarCurrentPosition());

        }
        System.out.println(cars.getWinner(cars.getMaxPosition()));
    }
}