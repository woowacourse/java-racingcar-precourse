package racingcar.domain.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveTest {
    
    @Test
    @DisplayName("포지션 증가")
    void increase() {
        Positive positive = new Positive(1);
        positive = positive.increase();
        
        assertThat(positive.number()).isEqualTo(2);
    }
}