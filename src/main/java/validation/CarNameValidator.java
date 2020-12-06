package validation;

public class CarNameValidator {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static void validateCarName(String carName) {
        String[] carNames = splitCarName(carName);
        try {
            validateCarNameCount(carNames);
            validateCarNameLength(carNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[] splitCarName(String carNames) {
        if (!carNames.contains(",")) {
            String[] carName = {carNames};
            return carName;
        }
        return carNames.split(",");
    }

    private static void validateCarNameCount(String[] carNames) {
        if (carNames.length == 1) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차는 한 대 이상이어야 합니다.");
        }
    }

    private static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < MINIMUM_CAR_NAME_LENGTH || MAXIMUM_CAR_NAME_LENGTH < carName.length()) {
                throw new IllegalArgumentException("[ERROR] 경주할 자동차의 이름은 1 이상 5이하여야 합니다.");
            }
        }
    }
}
