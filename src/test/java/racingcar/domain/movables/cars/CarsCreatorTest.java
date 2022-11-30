package racingcar.domain.movables.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.movables.engine.Movables;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsCreatorTest {
    @DisplayName("Cars 생성")
    @ParameterizedTest(name = "{displayName} : movableIndex => {0}, name => {1}")
    @CsvSource(value = {"0, jun", "1, pobi", "2, naru"})
    void create(final int movableIndex, final String name) {
        final Movables movables = new CarsCreator(new CarCreator()).create("jun,pobi,naru");
        final List<String> movablesName = movables.movablesName();
        final List<Integer> movablesPosition = movables.movablesPosition();
        
        assertAll(
                () -> assertThat(movablesName.get(movableIndex)).isEqualTo(name),
                () -> assertThat(movablesPosition.get(movableIndex)).isZero()
        );
    }
}