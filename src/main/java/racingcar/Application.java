package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        String carNames = inputView.receiveCarNames();
        CarValidator.validateDuplication(carNames);
    }
}
