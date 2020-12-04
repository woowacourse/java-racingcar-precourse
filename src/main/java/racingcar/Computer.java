package racingcar;

public class Computer {

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
}
