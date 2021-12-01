package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

	@Test
	@DisplayName("자동차가 앞으로 가긴 하는지 확인")
	void goCar() {
		Car player1 = new Car("jjun");
		int initPosition = player1.currentPosition();
		System.out.println("initPosition = " + initPosition);
		player1.go();
		int afterPosition = player1.currentPosition();
		System.out.println("afterPosition = " + afterPosition);
	}
}
