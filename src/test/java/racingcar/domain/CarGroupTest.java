package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarGroupTest {

    public static final String ERROR_PREFIX = "[ERROR]";

    List<Car> duplicatedCars = List.of(
            new Car("자동차"),
            new Car("자동차"),
            new Car("람보르기니")
    );

    @Test
    void CarGroup이_중복된_이름의_Car를_가질경우_예외() {
        Assertions.assertThatThrownBy(() -> new CarGroup(duplicatedCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX);
    }
}