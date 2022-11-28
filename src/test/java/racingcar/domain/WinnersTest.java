package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movables.cars.Car;
import racingcar.domain.movables.cars.Cars;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    
    @Test
    @DisplayName("이름 구하기")
    void winnersName() {
        final Car pobi = new Car("pobi");
        final Car naru = new Car("naru");
        
        final Winners winners = new Winners(List.of(pobi, naru));
    
        assertThat(winners.winnersName()).containsExactly("pobi", "naru");
    }
}