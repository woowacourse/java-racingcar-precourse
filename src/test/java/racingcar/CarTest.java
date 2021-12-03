package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Car 클래스")
class CarTest {

	private final Car carForwardTest = new Car("car");

	@DisplayName("Car 클래스 인스턴스가 제대로 생성이 되었는지 확인")
	@ParameterizedTest(name = "{index} {displayName} carName={0}")
	@ValueSource(strings = {"12345", "carName", "testName", "1", "str!"})
	void makeCarInstance(final String carName) {
		Car car = new Car(carName);

		assertEquals(carName, car.getName());
	}

	@DisplayName("Car 클래스 인스턴스가 제대로 전진되었는지 확인")
	@RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
	void forWardCar() {
		carForwardTest.goForward();

		final int currentPosition = carForwardTest.getPosition();
		final int carCurrentPosition = 0;

		assertTrue(currentPosition == carCurrentPosition
			|| currentPosition == carCurrentPosition + 1,
			"차량의 위치는 이전과 같거나 이전보다 1 증가되야 한다");
	}
}
