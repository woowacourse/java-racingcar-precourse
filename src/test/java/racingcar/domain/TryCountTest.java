package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TryCountTest {

    @Test
    void TryCount_생성자의_인자가_숫자가아니면_예외() {
        Assertions.assertThatThrownBy(() -> {
                    new TryCount("1000j");
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TRY_COUNT_MUST_BE_NUMBER.getMessage());
    }
}