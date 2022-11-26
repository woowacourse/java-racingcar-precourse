package racingcar.domain.movables.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movables.engine.Movable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarCreatorTest {
    @Test
    @DisplayName("Car 생성")
    void create() {
        final Movable jun = new CarCreator().create("jun");
        
        assertAll(
                () -> assertThat(jun.name()).isEqualTo("jun"),
                () -> assertThat(jun.position()).isZero()
        );
    }
}