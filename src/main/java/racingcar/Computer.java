package racingcar;

import utils.RandomUtils;

public class Computer {

    private static final String SIGN_DISTANCE = "-";
    private static final String COMMA = ",";

    public String[] parseCarList(String inputCarsName) {
        return inputCarsName.split(COMMA);
    }

    public void checkCarList(String[] carList) {
        if (carList.length == 0) {
            throw new IllegalArgumentException("Input Error");
        }
        for (String carName : carList) {
            if (!isAlpha(carName) || !checkNameLength(carName)) {
                throw new IllegalArgumentException("Input Error");
            }
        }
    }

    private static boolean checkNameLength(String carName) {
        return carName.length() > 0 && carName.length() <= Constants.MAX_NAME_LENGTH;
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

    public void isDigit(String tryCount) {
        for (int i = 0; i < tryCount.length(); i++) {
            char c = tryCount.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Input Error");
            }
        }
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
        for (Car car : cars) {
            if (moveOrStop()) {
                car.upPosition();
            }
        }
    }

    public void printCurrentCarsPosition(Car[] cars) {
        for (Car car : cars) {
            String carPosition = "";
            carPosition += car.getName() + " : ";
            carPosition += getSignDistance(car.getPosition());
            System.out.println(carPosition);
        }
        System.out.println();
    }

    private String getSignDistance(int len) {
        StringBuilder distance = new StringBuilder();

        for (int i = 0; i < len; i++) {
            distance.append(SIGN_DISTANCE);
        }

        return distance.toString();
    }

    public void printWinnerList(Car[] cars) {
        int longestDistance = getLongestDistance(cars);

        String winnerList = getWinnerList(cars, longestDistance);

        System.out.println("최종 우승자 : " + winnerList);
    }

    private String getWinnerList(Car[] cars, int longestDistance) {
        StringBuilder winnerList = new StringBuilder();

        for (Car car : cars) {
            if (car.getPosition() == longestDistance) {
                winnerList.append(car.getName() + COMMA + " ");
            }
        }
        //마지막에 추가된 , 제거
        return winnerList.substring(0, winnerList.length() - 2);
    }

    private int getLongestDistance(Car[] cars) {
        int longestDistance = 0;

        for (Car car : cars) {
            longestDistance = Math.max(longestDistance, car.getPosition());
        }
        return longestDistance;
    }
}
