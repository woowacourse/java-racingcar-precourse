package racingcar;

import utils.InputUtils;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        RacingStadium racingStadium = RacingStadium.of(scanner);
        racingStadium.start();
    }
}
