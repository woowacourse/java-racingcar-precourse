package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        ArrayList<Car> carList = GameSetting.carListCatchException(scanner);
        int trackLength = GameSetting.trackLengthException(scanner);

        GamePlay.play(trackLength, carList);
    }
}
