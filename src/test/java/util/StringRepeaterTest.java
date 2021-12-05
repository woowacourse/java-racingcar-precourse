package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringRepeaterTest {
    @Test
    @DisplayName("문자열과 횟수를 받아, 횟수만큼 문자열을 반복한 값을 반환한다.")
    void repeat() {
        String source = "any";
        int repeatingCount = 3;
        String actual = StringRepeater.repeat(source, repeatingCount);
        String expected = "anyanyany";
        assertThat(actual).isEqualTo(expected);
    }
}
