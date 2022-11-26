package racingcar.domain.movables.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movables.engine.Movables;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsCreatorTest {
    
    @Test
    @DisplayName("Cars 생성")
    void create() {
        final Movables movables = new CarsCreator(new CarCreator()).create("jun,pobi");
        final List<Movable> actualMovables = movables.movables();
        
        assertAll(
                () -> assertThat(actualMovables.get(0).name()).isEqualTo("jun"),
                () -> assertThat(actualMovables.get(1).name()).isEqualTo("pobi")
        );
    }
}