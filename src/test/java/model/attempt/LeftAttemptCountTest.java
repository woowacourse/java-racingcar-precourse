package model.attempt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LeftAttemptCountTest {
    @Test
    @DisplayName("남은 횟수를 줄이고 남은 횟수가 0이 아닌지 반환한다.")
    void isNotZero_decrease() {
        LeftAttemptCount leftAttemptCount = new LeftAttemptCount("2");
        leftAttemptCount.decrease();
        assertThat(leftAttemptCount.isNotZero()).isTrue();
        leftAttemptCount.decrease();
        assertThat(leftAttemptCount.isNotZero()).isFalse();
    }

    @ParameterizedTest
    @DisplayName("정수가 아닌 값 혹은, 0 이하의 정수로 객체를 생성하면 예외를 발생시킨다.")
    @ValueSource(strings = {"a", "0", "?"})
    void evokeExceptionByWrongValue(final String wrongValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LeftAttemptCount(wrongValue))
                .withMessage("이동 횟수는 0 이상의 정수여야 합니다.");
    }
}
