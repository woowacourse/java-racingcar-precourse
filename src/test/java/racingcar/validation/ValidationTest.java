package racingcar.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {
    private final String CAR_NAMES_NORMAL = "pobi,woni,jun";
    private final String ROUND_NUMBER_NORMAL = "20";

    @Test
    void 자동차_이름_입력_정상() {
        assertThat(Validation.inputCarNames(CAR_NAMES_NORMAL)).isEqualTo(CAR_NAMES_NORMAL);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,123,jun", "pobi, woni,jun", " pobi,woni,jun",
                            "pobi,woni,woowahan", ",pobi,jun", "pobi,woni,pobi",
                            ""})
    void 자동차_이름_입력_예외(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.inputCarNames(input))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 라운드_입력_정상() {
        assertThat(Validation.inputRoundCount(ROUND_NUMBER_NORMAL))
                .isEqualTo(Integer.parseInt(ROUND_NUMBER_NORMAL));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0", ""})
    void 라운드_입력_예외(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.inputRoundCount(input))
                .withMessageStartingWith("[ERROR]");
    }
}
