package racingcar.domain.movables.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movables.engine.MovablesCreator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovablesFactoryBeanTest {
    @Test
    @DisplayName("CarsCreator 생성")
    void createMovablesCreator() {
        final MovablesCreator movablesCreator = new MovablesFactoryBean().createMovablesCreator();
        final Movables movables = movablesCreator.create("jun,pobi");
        final List<Movable> actualMovables = movables.movables();
    
        assertAll(
                () -> assertThat(actualMovables.get(0).name()).isEqualTo("jun"),
                () -> assertThat(actualMovables.get(1).name()).isEqualTo("pobi")
        );
    }
}