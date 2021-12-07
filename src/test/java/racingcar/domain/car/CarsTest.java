package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.error.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("이름 리스트와 MovingPolicy이 주어지면 정상적으로 생성된다.")
    @Test
    void constructor_MovingConditionThenNotNull_Success() {
        // given
        MovingPolicy movingPolicy = new RandomMovingPolicy();
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));

        // when & then
        assertThatCode(() -> {
            new Cars(names, movingPolicy);
        }).doesNotThrowAnyException();
    }

    @DisplayName("차 이름이 중복되면 예외를 던진다.")
    @Test
    void constructor_NamesThenDuplicate_ExceptionThrown() {
        // given
        MovingPolicy movingPolicy = new RandomMovingPolicy();
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "pobi", "pobi"));

        // when & then
        assertThatThrownBy(() -> {
            new Cars(names, movingPolicy);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_NOT_DUPLICATE.getMessage());
    }

    @DisplayName("isMoving이 true이면 position이 일괄적으로 증가한다.")
    @Test
    void move_IsMovingThenTrue_CarsIncreasePosition() {
        // given
        MovingPolicy movingPolicy = () -> true;
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        System.out.println(cars.getExecutionResult());
        assertThat(cars.getExecutionResult()).isEqualTo("pobi : -\nwoni : -\njun : -");
    }

    @DisplayName("isMoving이 false이면 position은 일괄적으로 정지한다.")
    @Test
    void move_IsMovingThenFalse_CarsStopPosition() {
        // given
        MovingPolicy movingPolicy = () -> false;
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        assertThat(cars.getExecutionResult()).isEqualTo("pobi : \nwoni : \njun : ");
    }

    @DisplayName("최종 우승자 안내 문구를 생성한다.")
    @Test
    void getWinnersNames_Cars_WinnerNamesReturn() {
        // given
        MovingPolicy movingPolicy = () -> true;
        List<String> names = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        Cars cars = new Cars(names, movingPolicy);

        // when
        cars.move();

        // then
        assertThat(cars.getWinnersNames()).isEqualTo("pobi, woni, jun");
    }
}