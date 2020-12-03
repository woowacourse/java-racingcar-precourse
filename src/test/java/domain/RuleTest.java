package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Rule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RuleTest {
    @ParameterizedTest()
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    void 시도_횟수_양수_Rule_생성(int attemptNumber) {
        Rule rule = new Rule(attemptNumber);
        assertThat(rule).extracting("attemptNumber").isEqualTo(attemptNumber);
    }

    @ParameterizedTest()
    @ValueSource(ints = {0,-1})
    void 시도_횟수_양수아닌_Rule_생성(int attemptNumber) {
        assertThatThrownBy(() -> new Rule(attemptNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
