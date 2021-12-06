package racingcar.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarNamesValidatorTest {
    private final String CAR_NAMES_NORMAL = "pobi,woni,jun";

    @Test
    void 자동차_이름_입력_정상() {
        assertThat(CarNamesValidator.checkNamesAndReturn(CAR_NAMES_NORMAL)).isEqualTo(CAR_NAMES_NORMAL);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,123,jun", "pobi, woni,jun", " pobi,woni,jun",
            "pobi,woni,woowahan", ",pobi,jun", "pobi,woni,pobi",
            ""})
    void 자동차_이름_입력_예외(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNamesValidator.checkNamesAndReturn(input))
                .withMessageStartingWith("[ERROR]");
    }
}
