package racingcar;

import static racingcar.InputCarNames.getCarNames;

import exception.IllegalDuplicateException;
import exception.IllegalLengthException;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
        // for debugging
        for (String carName : carNames) {
            System.out.println("name: " + carName);
        }
    }

}
