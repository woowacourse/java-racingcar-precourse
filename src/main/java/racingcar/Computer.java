package racingcar;

import utils.RandomUtils;

public class Computer {

    private static final String SIGN_DISTANCE = "-";

    public String[] parseCarList(String inputCarsName) {

        String[] carList = inputCarsName.split(",");

        return carList;
    }

    public boolean checkCarList(String[] carList) {
        for (int i = 0; i < carList.length; i++) {
            if (!isAlpha(carList[i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isAlpha(String carName) {
        for (int i = 0; i < carName.length(); i++) {
            char c = carName.charAt(i);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                return false;
            }
        }

        return true;
    }

    public boolean isDigit(String tryCount) {
        for (int i = 0; i < tryCount.length(); i++) {
            char c = tryCount.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }

    private boolean moveOrStop() {
        int number = getRandomNumber();
        if (number >= Constants.STANDARD_NUMBER) {
            return true;
        }
        if (number < Constants.STANDARD_NUMBER) {
            return false;
        }

        return true;
    }

    private int getRandomNumber() {
        return RandomUtils.nextInt(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
    }

    public void moveCars(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if (moveOrStop()) {
                cars[i].upPosition();
            }
        }
    }

    public void printCurrentCarsPosition(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            String output = "";
            output += cars[i].getName() + " : ";
            output += getSignDistance(cars[i].getPosition());
            System.out.println(output);
        }
        System.out.println();
    }

    private String getSignDistance(int len) {
        String distance = "";

        for (int i = 0; i < len; i++) {
            distance += SIGN_DISTANCE;
        }

        return distance;
    }
}
