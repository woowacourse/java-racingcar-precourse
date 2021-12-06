package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차의 이름은 5자를 초과할 수 없다.")
	public void nameLengthExceed() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("abcdef"));
	}

	@Test
	@DisplayName("자동차의 이름은 비어있거나 null일 수 없다.")
	public void nameIsEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(""));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(null));
	}

	@Test
	@DisplayName("자동차는 랜덤한 확률로 이동할 수 있다.")
	public void movePosition() {
		Car car = new Car("test");
		for(int i=0;i<5;i++){
			car.move();
		}
		System.out.println(car);
	}
}
