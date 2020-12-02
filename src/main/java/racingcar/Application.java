package racingcar;

import racingcar.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] names = InputView.getNames(scanner);
    }
}
