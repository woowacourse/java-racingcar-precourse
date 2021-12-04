package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Cars;

class GameTest {
	Game game;

	@BeforeEach
	void 게임_생성() {
		game = new Game();
	}

	@Test
	void 자동차_생성() throws Exception {
		Method inputName = Game.class.getDeclaredMethod("inputName");
		inputName.setAccessible(true);

		Field carListField = Game.class.getDeclaredField("cars");
		carListField.setAccessible(true);

		Field carsField = Cars.class.getDeclaredField("cars");
		carsField.setAccessible(true);

		// given
		String input = "test1, test2";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when
		inputName.invoke(game);

		// then
		Cars cars = (Cars)carListField.get(game);
		List<Car> list = (List<Car>)carsField.get(cars);
		assertThat(list.size()).isEqualTo(2);
	}

	@Test
	void 숫자_입력() throws Exception {
		Method inputRunNumber = Game.class.getDeclaredMethod("inputRunNumber");
		inputRunNumber.setAccessible(true);

		Field runNumberField = Game.class.getDeclaredField("runNumber");
		runNumberField.setAccessible(true);

		// given
		int input = 5;
		InputStream in = new ByteArrayInputStream(Integer.toString(input).getBytes());
		System.setIn(in);

		// when
		inputRunNumber.invoke(game);

		// then
		int runNumber = runNumberField.getInt(game);
		assertThat(runNumber).isEqualTo(input);
	}
}