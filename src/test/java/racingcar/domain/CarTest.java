package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;
    @BeforeEach
    void SetUp(){

    }

    @Test
    void 글자길이가_5가_넘어가면_예외출력(){
        assertThatThrownBy(() -> {car = new Car("leeMinJae");})
                .isInstanceOf(IllegalArgumentException.class);

    }
}