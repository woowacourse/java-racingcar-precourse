package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    public void 다섯자_보다_긴_이름_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("programmer");
        });
        Assertions.assertEquals("[ERROR] 이름은 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    public void 공백인_이름_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name("");
        });
        Assertions.assertEquals("[ERROR] 이름은 공백일 수 없습니다.", exception.getMessage());
    }
}