package racingcar.domain.validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import racingcar.domain.CustomIllegalArgumentException;

public class NameValidator extends Validator {

    public static final int MINIMUM_NAME_LENGTH = 1;

    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static final String DELIMITER = ",";

    public static final String OUT_OF_RANGE_NAME_MESSAGE =
            String.format(
                    "자동차 이름은 %d글자 이상 %d글자 이하이어야 합니다. ", MINIMUM_NAME_LENGTH, MAXIMUM_NAME_LENGTH
            );

    public static final String INPUT_NAME_LENGTH_MESSAGE = "자동차 이름 %s의 길이는 %d글자입니다.";

    public static final String DUPLICATE_NAME_MESSAGE = "자동차 이름 %s는 중복된 이름입니다.";

    @Override
    public void validate(String carNames) {
        super.validate(carNames);

        String[] carNameTokens = Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);

        checkNameLength(carNameTokens);
        checkDuplicateName(carNameTokens);
    }

    public void checkNameLength(String[] carNameTokens) {
        for (String carName : carNameTokens) {
            int carNameLength = carName.length();

            if (carNameLength < MINIMUM_NAME_LENGTH || carNameLength > MAXIMUM_NAME_LENGTH) {
                throw new CustomIllegalArgumentException(OUT_OF_RANGE_NAME_MESSAGE +
                        String.format(INPUT_NAME_LENGTH_MESSAGE, carName, carNameLength));
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

            throw new CustomIllegalArgumentException(String.format(DUPLICATE_NAME_MESSAGE, carName));
        }
    }
}
