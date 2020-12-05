package racingcar.domain.validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import racingcar.domain.exception.CarCountOutOfBoundsException;
import racingcar.domain.exception.DuplicateNameException;
import racingcar.domain.exception.NameLengthOutOfBoundsException;
import racingcar.view.InputView;

public final class NameValidator extends Validator {

    public static final int MINIMUM_NAME_LENGTH = 1;

    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static final int MAXIMUM_CAR_COUNT = 8;

    @Override
    public void validate(final String carNames) {
        super.validate(carNames);

        final String[] carNameTokens = Arrays.stream(carNames.split(InputView.DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);

        checkCarCount(carNameTokens);
        checkAllCarNameLength(carNameTokens);
        checkDuplicateName(carNameTokens);
    }

    private void checkCarCount(final String[] carNameTokens) {
        final int carNamesLength = carNameTokens.length;

        if (carNamesLength > MAXIMUM_CAR_COUNT) {
            throw new CarCountOutOfBoundsException(carNamesLength);
        }
    }

    private void checkAllCarNameLength(final String[] carNameTokens) {
        for (String carName : carNameTokens) {
            checkCarNameLength(carName);
        }
    }

    private void checkCarNameLength(final String carName) {
        final int carNameLength = carName.length();

        if (carNameLength < MINIMUM_NAME_LENGTH || carNameLength > MAXIMUM_NAME_LENGTH) {
            throw new NameLengthOutOfBoundsException(carName, carNameLength);
        }
    }

    private void checkDuplicateName(final String[] carNameTokens) {
        final Map<String, Integer> nameCounts = new HashMap<>();

        for (String carName : carNameTokens) {
            nameCounts.merge(carName, 1, (first, second) -> {
                throw new DuplicateNameException(carName);
            });
        }
    }
}
