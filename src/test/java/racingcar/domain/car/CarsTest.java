package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.exception.CarNameDuplicationException;
import racingcar.domain.strategy.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {

    @DisplayName("Cars 객체 생성 성공 : 이름들에 중복이 없는 경우")
    @Test
    public void createCars_중복없는_이름들_객체_생성_성공() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(carNames, new RandomMovingStrategy());
        }).doesNotThrowAnyException();
    }

    @DisplayName("Cars 객체 생성 실패 : 이름들에 중복이 존재하는 경우")
    @Test
    public void createCars_중복있는_이름들_예외_발생() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(carNames, new RandomMovingStrategy());
        }).isInstanceOf(CarNameDuplicationException.class);
    }
}
