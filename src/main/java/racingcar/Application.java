package racingcar;

import inpututils.InputName;
import inpututils.inputRepetitions;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        new GameManagement(new InputName(scanner).inputPlayerName(), new inputRepetitions(scanner).inputanswer());
    }
}
