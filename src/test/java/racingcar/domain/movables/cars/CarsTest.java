package racingcar.domain.movables.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Winners;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private Cars cars;
    
    @BeforeEach
    void setUp() {
        final Car jun = initCar(new Car("jun"), 3);
        final Car pobi = initCar(new Car("pobi"), 1);
        final Car naru = initCar(new Car("naru"), 3);
    
        cars = new Cars(List.of(jun, pobi, naru));
    }
    
    private Car initCar(final Car car, final int numberOfMoves) {
        move(car, numberOfMoves);
        return car;
    }
    
    private void move(final Car car, final int numberOfMoves) {
        IntStream.range(0, numberOfMoves)
                .forEach(count -> car.move(() -> true));
    }
    
    @Test
    @DisplayName("우승자 이름 구하기")
    void winners() {
        final Winners winners = cars.winners();
        
        assertThat(winners.winnersName()).containsExactly("jun", "naru");
    }
    
    @Test
    @DisplayName("이름과 포지션 구하기")
    void nameAndPosition() {
        assertAll(
                () -> assertThat(cars.movablesName()).containsExactly("jun", "pobi", "naru"),
                () -> assertThat(cars.movablesPosition()).containsExactly(3, 1, 3)
        );
    }
}