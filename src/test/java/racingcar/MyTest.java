package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.InputView;

public class MyTest {
	@Test
	@DisplayName("Car 속 객체 확인")
	void Test1() {
		Car car = new Car("jiwoo");
		assertThat(car.getName())
			.isEqualTo("jiwoo");

		assertThat(car.getPosition())
			.isEqualTo(0);

		car.go();

		assertThat(car.getPosition())
			.isEqualTo(0);
	}

	@Test
	@DisplayName("최댓값 나오는지 확인")
	void Test2() {
		ArrayList<Integer> positions = new ArrayList<>();

		for (int i = 1; i < 6; i++) {
			positions.add(i);
		}
		System.out.println(positions);

		assertThat(RacingCars.findMax(positions))
			.isEqualTo(5);
	}

	@Test
	public void ex중복여부검사함수잘되나() {
		assertThat(InputView.isNotDuplicate(new String[] {"abc", "abc"}))
			.isEqualTo(false);
		assertThat(InputView.isNotDuplicate(new String[] {"abc", "bc"}))
			.isEqualTo(true);
	}

	@Test
	public void 빈거예외인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToStringArray("");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	@Test
	public void 정상작동인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToStringArray("지우,범주");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(false);
	}

	@Test
	public void 쉼표연속인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToStringArray("지우,,범주");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	@Test
	public void 쉼표앞인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToStringArray(",지우,범주");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	@Test
	public void 글자5자이상인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToStringArray("abcdef,agdwrh");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	@Test
	public void 이름중복인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToStringArray("abcdef,abcdef");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	@Test
	public void 이상한문자인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToStringArray("abcdef,ab=-");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	@Test
	public void 문자열이정수맞나() {
		assertThat(InputView.isInt("01"))
			.isEqualTo(false);

		assertThat(InputView.isInt("111"))
			.isEqualTo(true);
	}

	@Test
	public void 라운드이상한숫자인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToInt("01");
		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	@Test
	public void 라운드숫자인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToInt("5");
		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(false);
	}

	@Test
	public void 라운드숫자빈거인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputView.inputToInt("");
		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

	public static InputStream input(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}

	@Test
	public void 라운드총괄인풋뷰작동잘되나() {
		boolean exceptionCatched = false;

		try {
			// 여기에 오류 유발 코드를 구현한다.
			InputStream in = input("10");
			System.setIn(in);
			InputView.inputToInt(InputView.roundInput());
		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(false);
	}
}
