package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private Cars cars;
	private String input;
	private static final String participant1 = "kia";
	private static final String participant2 = "giron";
	private static int participantSize = 2;

	@BeforeEach
	void init() {
		this.cars = new Cars();
		this.input = participant1 + "," + participant2;
	}

	@Test
	@DisplayName("입력에 따른 참가 자동차들 참가되었는지 테스트 - 성공")
	void join() {

		cars.join(input);

		List<Car> carList = this.cars.getCars();
		assertAll(
			() -> assertThat(carList.get(0).getName()).isEqualTo(participant1),
			() -> assertThat(carList.get(1).getName()).isEqualTo(participant2),
			() -> assertThat(carList.size()).isEqualTo(participantSize)
		);

	}
}