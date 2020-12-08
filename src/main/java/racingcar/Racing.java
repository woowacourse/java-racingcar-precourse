package racingcar;

import utils.RandomUtils;

public class Racing {
    final static String racingRoad = "-";
    public static int maxPosition = 0;

    public static void playRace(Car[] carInstances) {
        for (int i = 0; i < carInstances.length; i++) {
            int moveCondition = RandomUtils.nextInt(0, 9);
            if (moveCondition >= 4) {
                carInstances[i].moveForward();
            }
            if (carInstances[i].getPosition() > maxPosition) {
                maxPosition = carInstances[i].getPosition();
            }
        }
        showResultView(carInstances);
        System.out.println();
    }

    public static void showResultView(Car[] carInstances) {
        for (int i = 0; i < carInstances.length; i++) {
            String carName = carInstances[i].getName();
            int carPosition = carInstances[i].getPosition();
            String positionResult = showPosition(carPosition);
            System.out.println(carName + " : " + positionResult);
        }
    }

    public static String showPosition(int carPosition) {
        String repeatString = "";
        for (int i = 0; i < carPosition; i++) {
            repeatString += racingRoad;
        }
        return repeatString;
    }
}
