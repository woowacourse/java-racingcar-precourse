package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {

    @DisplayName("Cars 객체 생성 성공 : 이름에 중복이 없는 경우")
    @Test
    public void createCars_중복없는_이름들_객체_생성_성공() {
        List<String> carNames = Arrays.asList("pobi", "crong", "jiko", "ajax");

        assertThatCode(() -> {
            Cars.createCars(carNames);
        }).doesNotThrowAnyException();
    }
}
