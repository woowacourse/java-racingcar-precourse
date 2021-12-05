package model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CarTest {
    private final Car car = new Car("Chris");

    @BeforeEach
    void setUp() {
        car.move(true);
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void getName() {
        String actual = car.getName();
        String expected = "Chris";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차를 전진시키고 전진에 따른 위치 값을 반환한다.")
    void move_getPosition() {
        car.move(false);
        int actual = car.getPosition();
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("다른 Car 객체를 받아 자신의 위치 값이 더 크면 같으면 true, 작으면 false를 반환한다.")
    @MethodSource("provideAnotherCarAndExpected")
    void hasHigherPositionThan(final Car another, final boolean expected) {
        boolean actual = car.hasHigherPositionThan(another);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideAnotherCarAndExpected() {
        Car higherPositionCar = new Car("2");
        Car equalPositionCar = new Car("1");
        Car lowerPositionCar = new Car("0");
        higherPositionCar.move(true);
        higherPositionCar.move(true);
        equalPositionCar.move(true);
        return Stream.of(
                Arguments.of(higherPositionCar, false),
                Arguments.of(equalPositionCar, true),
                Arguments.of(lowerPositionCar, true)
        );
    }

    @ParameterizedTest
    @DisplayName("이름과 위치 값을 기준으로 동등성을 판단한다.")
    @MethodSource("provideAnotherCarAndExpectedEquality")
    void equals(final Car anotherCar, final boolean expected) {
        boolean actual = car.equals(anotherCar);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("이름과 위치 값을 기반으로 해시코드를 반환한다.")
    @MethodSource("provideAnotherCarAndExpectedEquality")
    void hashCode(final Car anotherCar, final boolean expected) {
        int hashCodeOfCar = car.hashCode();
        int hashCodeOfAnotherCar = anotherCar.hashCode();
        assertThat(hashCodeOfCar == hashCodeOfAnotherCar).isEqualTo(expected);
    }

    private static Stream<Arguments> provideAnotherCarAndExpectedEquality() {
        Car firstCar = new Car("Chris");
        firstCar.move(true);
        Car secondCar = new Car("Chris");
        Car thirdCar = new Car("Henry");
        return Stream.of(
                Arguments.of(firstCar, true),
                Arguments.of(secondCar, false),
                Arguments.of(thirdCar, false)
        );
    }
}
