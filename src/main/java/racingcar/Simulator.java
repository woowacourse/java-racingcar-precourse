package racingcar;

import utils.RandomUtils;

public class Simulator {
    public static final String SIMULATE_RESULT_MESSAGE = "실행 결과";
    public static final String SHOW_RACING_NAME_MARGIN = " : ";
    public static final String RACING_ROAD = "-";
    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;

    public static void simulateRace(Car[] gameCars, int gameRound) {
        System.out.println();
        System.out.println(SIMULATE_RESULT_MESSAGE);
        for (int i = 0; i < gameRound; i++) {
            progressOneRound(gameCars);
            showRacing(gameCars);
        }
    }

    public static void progressOneRound(Car[] gameCars) {
        for (Car car : gameCars) {
            if (getRandomNumber() >= 4) {
                car.moveCar();
            }
        }
    }

    public static void showRacing(Car[] gameCars) {
        for (Car car : gameCars) {
            System.out.println(car.getName() + SHOW_RACING_NAME_MARGIN + getStringRoad(car.getPosition()));
        }
        System.out.println();
    }

    public static int getRandomNumber() {
        int num = RandomUtils.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
        return num;
    }

    public static String getStringRoad(int position) {
        String stringRoad = "";
        for (int i = 0; i < position; i++) {
            stringRoad += RACING_ROAD;
        }
        return stringRoad;
    }
}