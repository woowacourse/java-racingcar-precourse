package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TryNumberTest {

    @Test
    void getTryNumber() {
        TryNumber tryNumber = new TryNumber();

        assertThatThrownBy(() -> {
            tryNumber.getTryNumber("");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}