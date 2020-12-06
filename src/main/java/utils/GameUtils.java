package utils;

public class GameUtils {
    public GameUtils() {
    }

    public boolean isRightCarName(String userCarsName) {
        if (userCarsName.length() <= 5) return true;
        return false;
    }

    public boolean isNumber(String userNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            if (!Character.isDigit(userNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
