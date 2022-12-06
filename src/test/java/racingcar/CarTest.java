package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarMoveNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class CarTest {

    private static final String EXCEPTION_MESSAGE_CAR_NAME_LENGTH = "[ERROR] 자동차이름은 5글자 이하입니다";

    @DisplayName("Car 객체를 성공적으로 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobii", "p", "pob", "3%$^1", "세글자", "k   l"})
    void createCarSuccess(String input) {
        boolean result = true;
        try{
            new Car(input);
        }catch (IllegalArgumentException exception) {
            result = false;
        }
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("5글자 초과시 Car 생성시 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiid", "dafasdfasdfasdshgsdfg"})
    void createCarByOverLength(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_CAR_NAME_LENGTH);
    }

    @DisplayName("자동차가 4 이상의 숫자가 들어올시 움직인다.")
    @Test
    void moveCarSuccess() {
        Car car = new Car("pobi");
        CarMoveNumberGenerator carMoveNumberGenerator
                = new TestNumberGenerator(newArrayList(4, 5, 6, 7, 8, 9));
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);

        assertThat(car).extracting("position").isEqualTo(6);
    }

    @DisplayName("자동차가 4 이하의 숫자가 들어올시 움직이지 않는다.")
    @Test
    void moveCarFail() {
        Car car = new Car("pobi");
        CarMoveNumberGenerator carMoveNumberGenerator
                = new TestNumberGenerator(newArrayList(0, 1, 2, 3));
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);
        car.move(carMoveNumberGenerator);

        assertThat(car).extracting("position").isEqualTo(0);
    }

    static class TestNumberGenerator implements CarMoveNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
