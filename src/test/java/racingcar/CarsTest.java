package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@Test
	@DisplayName("문자열 입력 받아 cars List로 저장")
	void mapCarTest() {
		List<Car> testCars = new ArrayList<>();
		testCars.add(new Car("abc"));
		testCars.add(new Car("def"));
		testCars.add(new Car("ghi"));

		List<String> testList = new ArrayList<>();
		testList.add("abc");
		testList.add("def");
		testList.add("ghi");
		Cars generatedCars = new Cars(testList);
		assertThat(generatedCars.cars.get(0).getName()).isEqualTo(testCars.get(0).getName());
	}
}
