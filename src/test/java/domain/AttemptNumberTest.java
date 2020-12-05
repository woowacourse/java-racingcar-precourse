package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.AttemptNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AttemptNumberTest {
    @ParameterizedTest()
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void 시도_횟수_자연수_AttemptNumber_생성(int attemptNumber) {
        AttemptNumber attemptNumberClass = new AttemptNumber(attemptNumber);
        assertThat(attemptNumberClass).extracting("attemptNumber").isEqualTo(attemptNumber);
    }

    @ParameterizedTest()
    @ValueSource(ints = {0,-1})
    void 시도_횟수_자연수아닌_AttemptNumber_생성(int attemptNumber) {
        assertThatThrownBy(() -> new AttemptNumber(attemptNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
