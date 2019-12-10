package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car에 대한 Test")
class CarTest {

	@DisplayName("차의 이름이 5자 초과로 입력될 경우 Throw 발생")
	@Test
	public void generateCar() {
		assertThrows(IllegalArgumentException.class, () -> {
			Car car = new Car("mjung_car", 1);
		});
	}

}