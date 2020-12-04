package racingcar;

import utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<Car>();
        Round round = new Round();

        InputUtils.inputNames(scanner, cars);
        InputUtils.inputTryNumber(scanner, round);


        scanner.close();
    }
}
