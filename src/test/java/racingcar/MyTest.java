package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
