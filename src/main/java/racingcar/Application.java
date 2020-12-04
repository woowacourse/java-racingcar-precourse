package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String[] carNames = UserInput.getCarNames(scanner);
        int stageCount = UserInput.getStageCount(scanner);
    }
}
