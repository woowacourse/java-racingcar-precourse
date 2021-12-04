package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class NamingProcessTest {

	@Test
	void 이름_파싱() {
		// given
		String input = "pobi,woni,jun";

		// when
		String[] parsedName = NamingProcess.parseString(input);

		// then
		assertArrayEquals(new String[] {"pobi", "woni", "jun"}, parsedName);
	}

	@Test
	void 자동차_이름_리스트반환() {
		// given
		String input = "pobi,woni,jun";
		String[] nameList = NamingProcess.parseString(input);

		// when
		Car[] cars = NamingProcess.StringToArray(nameList);

		// then
		assertThat(cars.length).isEqualTo(3);
		assertThat(cars[0].getName()).isEqualTo("pobi");
		assertThat(cars[1].getName()).isEqualTo("woni");
		assertThat(cars[2].getName()).isEqualTo("jun");
	}
}
