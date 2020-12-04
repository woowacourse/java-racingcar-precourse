package racingcar;

import utils.RandomUtils;

public class Simulator {
    public static void simulateRace(Car[] gameCars, int gameRound) {
        for (int i=0; i < gameCars.length; i++){
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
            System.out.println(car.getName() + GameConstants.SHOW_RACING_NAME_MARGIN + getStringRoad(car.getPosition()));
        }
        System.out.println();
    }

    public static int getRandomNumber() {
        int num = RandomUtils.nextInt(GameConstants.MIN_RANDOM_NUM, GameConstants.MAX_RANDOM_NUM);
        return num;
    }

    public static String getStringRoad(int position) {
        String stringRoad = "";
        for (int i = 0; i < position; i++) {
            stringRoad += GameConstants.RACING_ROAD;
        }
        return stringRoad;
    }
}
