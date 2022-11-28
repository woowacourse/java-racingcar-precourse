package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveTest {
    @Test
    @DisplayName("숫자 증가")
    void increase() {
        Positive positive = new Positive(1);
        positive = positive.increase();
        
        assertThat(positive.number()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("숫자가 동일한지 확인")
    void isSame() {
        Positive positive = new Positive(2);
        
        assertThat(positive.isSame(2)).isTrue();
    }
}