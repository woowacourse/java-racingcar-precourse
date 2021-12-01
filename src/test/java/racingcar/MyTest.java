package racingcar;

import static org.assertj.core.api.Assertions.*;

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
	public void ex정규식일케쓰는거맞나() {
		String pattern = "^[가-힣\\w,]*$";

		assertThat("abc,".matches(pattern))
			.isEqualTo(true);

		assertThat("abc-".matches(pattern))
			.isEqualTo(false);

		assertThat(",".matches(pattern))
			.isEqualTo(true);

		assertThat("가나다,다라마".matches(pattern))
			.isEqualTo(true);

		assertThat("가나다,다라마-".matches(pattern))
			.isEqualTo(false);
		assertThat("가나다,다라마123".matches(pattern))
			.isEqualTo(true);
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
			InputView.InputToStringArray("");

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
			InputView.InputToStringArray("지우,범주");

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
			InputView.InputToStringArray("지우,,범주");

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
			InputView.InputToStringArray(",지우,범주");

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
			InputView.InputToStringArray("abcdef,agdwrh");

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
			InputView.InputToStringArray("abcdef,abcdef");

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
			InputView.InputToStringArray("abcdef,ab=-");

		} catch (IllegalArgumentException e) {
			exceptionCatched = true;
		}
		assertThat(exceptionCatched)
			.isEqualTo(true);
	}

}
