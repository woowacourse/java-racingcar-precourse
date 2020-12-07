package utils;

public class SplitUtils {
    private static final String COMMA = ",";
    
    private SplitUtils() {
    }

    public static String[] splitCarName(String carNames) {
        if (!carNames.contains(COMMA)) {
            String[] carName = {carNames};
            return carName;
        }
        return carNames.split(COMMA);
    }
}
