package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TotalRoundTest {
    @Test
    void 숫자가_아닌_라운드_입력_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String string = "r";
            new TotalRound(string);
        });
        Assertions.assertEquals("[ERROR] 시도할 횟수는 숫자를 입력해야 합니다.", exception.getMessage());
    }

    @Test
    void 숫자_0입력_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String zero = "0";
            new TotalRound(zero);
        });
        Assertions.assertEquals("[ERROR] 횟수는 0을 입력할 수 없습니다.", exception.getMessage());
    }
}