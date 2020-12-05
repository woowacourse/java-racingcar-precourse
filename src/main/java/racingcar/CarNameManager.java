package racingcar;

import java.util.HashSet;

public class CarNameManager {
    protected static final int MINIMUM_CAR_NAME_LENGTH = 1;
    protected static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    
    public static GameStatus checkValidCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!isValidNameLength(carName)) {
                return GameStatus.INVALID_NAME_LENGTH;
            }
        }
        if (hasRedundancy(carNames)) {
            return GameStatus.DUPLICATED_NAME;
        }
        return GameStatus.OK;
    }
    
    private static boolean isValidNameLength(String carName) {
        int length = carName.length();
        if (length < MINIMUM_CAR_NAME_LENGTH || length > MAXIMUM_CAR_NAME_LENGTH) {
            return false;
        }
        return true;
    }
    
    private static boolean hasRedundancy(String[] carNames) {
        HashSet<String> nameSet = new HashSet<String>();
        for (String carName : carNames) {
            nameSet.add(carName);
        }
        return (nameSet.size() != carNames.length);
    }
}
