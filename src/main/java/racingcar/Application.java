package racingcar;

import utils.InputUtils;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        InputUtils inputUtils = InputUtils.of(scanner);
        String[] carNames = inputUtils.inputAndGetCarNames();
        for (String carName : carNames) {
            System.out.println("carName = " + carName);
        }
    }
}
