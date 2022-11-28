package racingcar.domain.movables.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.movables.engine.Movable;
import racingcar.domain.movables.engine.Movables;
import racingcar.domain.movables.engine.MovablesCreator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovablesFactoryBeanTest {
    @DisplayName("CarsCreator 생성")
    @ParameterizedTest(name = "{displayName} : movableIndex => {0}, name => {1}")
    @CsvSource(value = {"0, jun", "1, pobi", "2, naru"})
    void createMovablesCreator(final int movableIndex, final String name) {
        final MovablesCreator movablesCreator = new MovablesFactoryBean().createMovablesCreator();
        final Movables movables = movablesCreator.create("jun,pobi,naru");
        final List<String> movablesName = movables.movablesName();
        final List<Integer> movablesPosition = movables.movablesPosition();
        
        assertAll(
                () -> assertThat(movablesName.get(movableIndex)).isEqualTo(name),
                () -> assertThat(movablesPosition.get(movableIndex)).isZero()
        );
    }
}