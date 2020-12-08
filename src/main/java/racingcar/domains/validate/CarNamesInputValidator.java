package racingcar.domains.validate;

import racingcar.domains.error.ErrorMessageGenerator;
import racingcar.domains.error.RacingCarGameException;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CarNamesInputValidator implements Validator<String> {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final String DELIMITER = ",";

    private static final String INVALID_FORMAT_MESSAGE =
            ErrorMessageGenerator.generateErrorMessage("입력 형식이 부정확 합니다.");
    private static final String INVALID_CAR_NAME_LENGTH_MESSAGE =
            ErrorMessageGenerator
                    .generateErrorMessage("자동차 이름의 길이가" + MAXIMUM_CAR_NAME_LENGTH + "보다 깁니다.");

    private static final String CAR_NAMES_INPUT_FORMAT =
            "((( *)([가-힣]|\\w)+( *))+,?)+(.(( *)([가-힣]|\\w)+( *)))$";

    private String carNames;

    @Override
    public void isValid(String carNames) throws RacingCarGameException {
        this.carNames = carNames;

        isRightFrom();
        isRightLength();
    }

    private void isRightFrom() throws RacingCarGameException {
        if (!Pattern.matches(CAR_NAMES_INPUT_FORMAT, carNames)) {
            throw new RacingCarGameException(INVALID_FORMAT_MESSAGE);
        }
    }

    private void isRightLength() throws RacingCarGameException {
        String[] splitCarNames = carNames.split(DELIMITER);

        final long count = Arrays.stream(splitCarNames)
                .map(String::trim)
                .filter(carName -> carName.length() <= MAXIMUM_CAR_NAME_LENGTH)
                .count();

        if(splitCarNames.length != count) {
            throw new RacingCarGameException(INVALID_CAR_NAME_LENGTH_MESSAGE);
        }
    }
}
