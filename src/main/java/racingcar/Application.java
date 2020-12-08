package racingcar;

import static racingcar.InputCarNames.getCarNames;
import static racingcar.InputTryCount.getTryCount;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
        int tryCount = getTryCount(scanner);
    }
}
