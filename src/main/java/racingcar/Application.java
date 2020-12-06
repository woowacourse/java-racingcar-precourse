package racingcar;

import racingcar.view.InputView;

import java.util.Scanner;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        InputView inputView = new InputView(scanner);
        List<String> nameList = inputView.scanCarName();
    }
}
