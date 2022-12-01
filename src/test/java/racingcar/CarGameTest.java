package racingcar;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarGameTest {

    @Test
    @DisplayName("자동차 경주 자동차 등록 성공 테스트")
    void 자동차_등록_성공_테스트() {
        //given
        CarGame carGame = new CarGame();
        //when
        List<String> cars = Arrays.asList("pobi", "woni", "jun");
        carGame.registerCar(cars);
        //then
        List<String> carNames = carGame.getCars()
            .stream()
            .map(Car::getName)
            .collect(Collectors.toList());

        assertThat(carNames)
            .contains("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 경주 자동차 등록 실패 테스트")
    void 자동차_등록_실패_테스트() {
        //given
        CarGame carGame = new CarGame();
        //when
        List<String> cars = new ArrayList<>();
        //then
        assertThatThrownBy(() -> carGame.registerCar(cars))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
