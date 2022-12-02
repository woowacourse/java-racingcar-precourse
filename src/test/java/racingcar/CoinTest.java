package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinTest {
    private static final int LIMIT = 10_000;

    @Test
    void Coin_LIMIT_이상_게임을_수행하려_하면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Coin(1_000_000))
                .hasMessage("[ERROR] 게임 실행 횟수는 " + LIMIT + "번 이상 수행될 수 없습니다");
    }
}
