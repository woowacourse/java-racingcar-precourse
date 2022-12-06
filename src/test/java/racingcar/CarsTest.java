package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarMoveNumberGenerator;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class CarsTest {

    private static final String EXCEPTION_MESSAGE_CARS_DUPLICATED_NAME = "[ERROR] 자동차 이름은 중복될 수 없습니다";

    @DisplayName("Cars 객체를 성공적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobii,pop,p", "p", "pob,pb,bb,dcd,wqwqg,xvd,aw,be", "pb,,pob,,,bo"})
    void createCarsSuccess(String input) {
        boolean result = true;
        try {
            Cars.createCarNameByWord(input);
        } catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("Cars 객체 생성시 중복되는 자동차 이름이있다")
    @ParameterizedTest
    @ValueSource(strings = {"d,gme,d", "wwwww,ef,weah,wwwww,wwwww", "d,d,d,d,d,d,d,d,d,d"})
    void createCarsByDuplicatedName(String input) {
        assertThatThrownBy(() -> Cars.createCarNameByWord(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_CARS_DUPLICATED_NAME);
    }

    @DisplayName("모든 자동차가 정상적으로 움직인다.")
    @Test
    void moveCarsSuccess() {
        Cars cars = Cars.createCarNameByWord("pobi,randi,rudy");
        CarMoveNumberGenerator carMoveNumberGenerator
                = new CarTest.TestNumberGenerator(newArrayList(4, 2, 6, 9, 5, 6, 4, 0, 1));
        cars.move(carMoveNumberGenerator);
        cars.move(carMoveNumberGenerator);
        cars.move(carMoveNumberGenerator);

        assertThat(cars.getCars().get(0)).extracting("position").isEqualTo(3);
        assertThat(cars.getCars().get(1)).extracting("position").isEqualTo(1);
        assertThat(cars.getCars().get(2)).extracting("position").isEqualTo(2);
    }

    @DisplayName("우승자를 찾아서 반환한다")
    @Test
    void findWinnerSuccess() {
        Cars cars = Cars.createCarNameByWord("pobi,randi,rudy");
        CarMoveNumberGenerator carMoveNumberGenerator
                = new CarTest.TestNumberGenerator(newArrayList(4, 2, 6, 9, 5, 6, 4, 0, 7));
        cars.move(carMoveNumberGenerator);
        cars.move(carMoveNumberGenerator);
        cars.move(carMoveNumberGenerator);

        List<String> result = new ArrayList<>();
        result.add("pobi");
        result.add("rudy");
        assertThat(cars.findWinner().getWinner()).isEqualTo(result);
    }
}
