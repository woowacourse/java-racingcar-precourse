package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
class CountTest {
    Count count = new Count();

    @Test
    @DisplayName("Int로 변환이 안되는 경우")
    void invalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> count.validate("한글"));
        assertThrows(IllegalArgumentException.class, () -> count.validate("english"));
        assertThrows(IllegalArgumentException.class, () -> count.validate("3.14"));
        assertThrows(IllegalArgumentException.class, () -> count.validate("!!?"));
    }

    @Test
    @DisplayName("시도 횟수가 1 미만인 경우")
    void invalidMinimumNumber() {
        assertThrows(IllegalArgumentException.class, () -> count.validate("0"));
        assertThrows(IllegalArgumentException.class, () -> count.validate("-1"));
    }

    @Test
    @DisplayName("시도 횟수가 30 초과인 겨웅")
    void invalidMaximumNumber() {
        assertThrows(IllegalArgumentException.class, () -> count.validate("31"));
    }
}
