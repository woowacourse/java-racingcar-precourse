package racingcar.domain.validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import racingcar.domain.exception.DuplicateNameException;
import racingcar.domain.exception.NameLengthOutOfBoundsException;
import racingcar.domain.exception.ValidationException;

public class NameValidator extends Validator {

    public static final int MINIMUM_NAME_LENGTH = 1;

    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static final int MAXIMUM_CAR_COUNT = 8;

    public static final String DELIMITER = ",";

    public static final String OUT_OF_BOUNDS_MESSAGE =
            String.format("자동차의 대수는 %d 이하이어야 합니다.", MAXIMUM_CAR_COUNT);

    public static final String INPUT_CAR_COUNT_MESSAGE = "입력한 자동차의 대수는 %d 입니다";

    @Override
    public void validate(String carNames) {
        super.validate(carNames);

        String[] carNameTokens = Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);

        checkCarCount(carNameTokens);
        checkNameLength(carNameTokens);
        checkDuplicateName(carNameTokens);
    }

    private void checkCarCount(String[] carNameTokens) {
        int carNamesLength = carNameTokens.length;
        if (carNamesLength > MAXIMUM_CAR_COUNT) {
            throw new ValidationException(OUT_OF_BOUNDS_MESSAGE +
                    String.format(INPUT_CAR_COUNT_MESSAGE, carNamesLength));
        }
    }

    public void checkNameLength(String[] carNameTokens) {
        for (String carName : carNameTokens) {
            int carNameLength = carName.length();

            if (carNameLength < MINIMUM_NAME_LENGTH || carNameLength > MAXIMUM_NAME_LENGTH) {
                throw new NameLengthOutOfBoundsException(carName, carNameLength);
            }
        }
    }

    public void checkDuplicateName(String[] carNameTokens) {
        Map<String, Integer> nameCounts = new HashMap<>();

        for (String carName : carNameTokens) {
            if (!nameCounts.containsKey(carName)) {
                nameCounts.put(carName, 1);
                continue;
            }

            throw new DuplicateNameException(carName);
        }
    }
}
