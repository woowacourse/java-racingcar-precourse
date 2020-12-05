package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        ArrayList<Car> carList = GameSetting.carList(scanner);
        int trackLength = GameSetting.trackLength(scanner);
        GamePlay.play(trackLength, carList);
    }
}
