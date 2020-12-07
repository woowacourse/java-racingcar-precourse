package utils;

public class SplitUtils {
    private SplitUtils() {
    }

    public static String[] splitCarName(String carNames) {
        if (!carNames.contains(",")) {
            String[] carName = {carNames};
            return carName;
        }
        return carNames.split(",");
    }
}
