package racingcar.validators;

import org.junit.jupiter.api.Test;
import racingcar.exceptions.NotNumericTrialCountException;
import racingcar.exceptions.NotPositiveTrialCountException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TrialCountValidatorTest {
    @Test
    public void 올바른_시도횟수_입력시_예외_발생_안함() {
        //given
        String rawTrialCount = "1";

        //when & then
        assertDoesNotThrow(() -> TrialCountValidator.validateTrialCount(rawTrialCount));
    }

    @Test
    public void 정수형이_아닌_시도횟수_입력시_예외_발생() {
        //given
        String rawTrialCount = "한글입력";

        //when & then
        assertThatExceptionOfType(NotNumericTrialCountException.class)
                .isThrownBy(() -> TrialCountValidator.validateTrialCount(rawTrialCount));
    }

    @Test
    private void 양수가_아닌_시도횟수_입력시_예외_발생() {
        //given
        String rawTrialCount = "0";

        //when & then
        assertThatExceptionOfType(NotPositiveTrialCountException.class)
                .isThrownBy(() -> TrialCountValidator.validateTrialCount(rawTrialCount));
    }
}