package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static racingcar.Constants.DIVIDER_FOR_SPLIT;
import static racingcar.Constants.MAX_ATTEMPT;
import static racingcar.Constants.MAX_CAR_NAME_LENGTH;
import static racingcar.Constants.MIN_ATTEMPT;
import static racingcar.Constants.MIN_CAR_NAME_LENGTH;
import static racingcar.UtilityFunctions.parseCarNameArrayString;
import static racingcar.UtilityFunctions.parseMaxAttemptString;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UtilityFunctionsTest {

    private static final String EMPTY_STRING = "";
    private static final String VALID_ATTEMPT_STRING = Integer.toString(MIN_ATTEMPT);
    private static final String INVALID_ATTEMPT_STRING_WITH_STRANGE_FORMAT = "a";
    private static final String INVALID_ATTEMPT_STRING_WITH_SMALLER_VALUE = Integer
        .toString(MIN_ATTEMPT - 1);
    private static final String INVALID_ATTEMPT_STRING_WITH_LARGER_VALUE = Integer
        .toString(MAX_ATTEMPT + 1);
    private static final String INVALID_CAR_NAME_LENGTH_STRING = String.format(
        ErrorMessage.INVALID_CAR_NAME_LENGTH.toString(), MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH
    );
    private static final String INVALID_ATTEMPT_RANGE_ERROR_MESSAGE = String.format(
        ErrorMessage.INVALID_ATTEMPT_RANGE.toString(), MIN_ATTEMPT, MAX_ATTEMPT
    );
    private static String validCarName1;
    private static String validCarName2;
    private static String invalidCarNameWithShorterLength;
    private static String invalidCarNameWithLongerLength;
    private static String invalidAttemptStringWithOutOfIntegerRange;

    @BeforeAll
    static void init() {
        StringBuilder stringBuilderForValidCarName1 = new StringBuilder();
        StringBuilder stringBuilderForValidCarName2 = new StringBuilder();
        StringBuilder stringBuilderForInvalidCarNameWithShorterLength = new StringBuilder();
        StringBuilder stringBuilderForInvalidCarNameWithLongerLength = new StringBuilder();

        for (int i = 0; i < MAX_CAR_NAME_LENGTH; i++) {
            stringBuilderForValidCarName1.append('a');
            stringBuilderForValidCarName2.append('b');
        }

        for (int i = 0; i < MIN_CAR_NAME_LENGTH - 1; i++) {
            stringBuilderForInvalidCarNameWithShorterLength.append('a');
        }
        for (int i = 0; i < MAX_CAR_NAME_LENGTH + 1; i++) {
            stringBuilderForInvalidCarNameWithLongerLength.append('a');
        }

        validCarName1 = stringBuilderForValidCarName1.toString();
        validCarName2 = stringBuilderForValidCarName2.toString();
        invalidCarNameWithShorterLength = stringBuilderForInvalidCarNameWithShorterLength
            .toString();
        invalidCarNameWithLongerLength = stringBuilderForInvalidCarNameWithLongerLength.toString();

        StringBuilder stringBuilderForInvalidAttemptStringWithOutOfIntegerRange = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            stringBuilderForInvalidAttemptStringWithOutOfIntegerRange.append(i);
        }

        invalidAttemptStringWithOutOfIntegerRange = stringBuilderForInvalidAttemptStringWithOutOfIntegerRange
            .toString();
    }

    @Test
    void parseCarNameArrayString_ValidString_NoExceptionThrown() {
        assertThatCode(() -> {
            final String validCarNameArrayString =
                validCarName1 + DIVIDER_FOR_SPLIT + validCarName2;
            parseCarNameArrayString(validCarNameArrayString);
        }).doesNotThrowAnyException();
    }

    @Test
    void parseCarNameArrayString_ItemDuplicated_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final String validCarNameArrayString =
                validCarName1 + DIVIDER_FOR_SPLIT + validCarName1;
            parseCarNameArrayString(validCarNameArrayString);
        }).withMessage(ErrorMessage.DUPLICATED_CAR_NAME.toString());
    }

    @Test
    void parseCarNameArrayString_EmptyString_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseCarNameArrayString(EMPTY_STRING);
        }).withMessage(INVALID_CAR_NAME_LENGTH_STRING);
    }

    @Test
    void parseCarNameArrayString_stringWithNoCarName_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseCarNameArrayString(DIVIDER_FOR_SPLIT);
        }).withMessage(INVALID_CAR_NAME_LENGTH_STRING);
    }

    @Test
    void parseCarNameArrayString_ShorterCarNameLength_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseCarNameArrayString(invalidCarNameWithShorterLength);
        }).withMessage(INVALID_CAR_NAME_LENGTH_STRING);
    }

    @Test
    void parseCarNameArrayString_LongerCarNameLength_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseCarNameArrayString(invalidCarNameWithLongerLength);
        }).withMessage(INVALID_CAR_NAME_LENGTH_STRING);
    }

    @Test
    void parseMaxAttemptString_ValidFormat_NoExceptionThrown() {
        assertThatCode(() -> {
            parseMaxAttemptString(VALID_ATTEMPT_STRING);
        }).doesNotThrowAnyException();
    }

    @Test
    void parseMaxAttemptString_InvalidFormat_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseMaxAttemptString(INVALID_ATTEMPT_STRING_WITH_STRANGE_FORMAT);
        }).withMessage(ErrorMessage.INVALID_ATTEMPT_STRING_FORMAT.toString());
    }

    @Test
    void parseMaxAttemptString_OutOfIntegerRange_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseMaxAttemptString(invalidAttemptStringWithOutOfIntegerRange);
        }).withMessage(ErrorMessage.INVALID_ATTEMPT_INTEGER.toString());
    }

    @Test
    void parseMaxAttemptString_LargerThanMaxValue_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseMaxAttemptString(INVALID_ATTEMPT_STRING_WITH_LARGER_VALUE);
        }).withMessage(INVALID_ATTEMPT_RANGE_ERROR_MESSAGE);
    }

    @Test
    void parseMaxAttemptString_SmallerThanMaxValue_ExceptionThrown() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parseMaxAttemptString(INVALID_ATTEMPT_STRING_WITH_SMALLER_VALUE);
        }).withMessage(INVALID_ATTEMPT_RANGE_ERROR_MESSAGE);
    }
}
