package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.service.ValidationService;

public class ValidationServiceTest {
	public static final String DELIMITER = ",";

	@DisplayName("입력받은 자동차 이름들의 예외 처리 작업을 수행")
	@ParameterizedTest
	@ValueSource(strings = {"", ",", "pobi"})
	void checkCarNames(String carNames) {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationService.checkCarNames(carNames, DELIMITER);
		});
	}

	@DisplayName("한 자동차의 이름에 대한 예외 처리 작업을 수행")
	@Test
	void checkEachCarName() {
		assertThrows(IllegalArgumentException.class, () -> {
			// [예외처리]  구분된 자동차의 이름이 비어있을 때
			ValidationService.checkEachCarName(Arrays.asList("Jane", "Karry", ""));
			// [예외처리]  구분 된 자동차의 이름의 길이가 6 이상일 때
			ValidationService.checkEachCarName(Arrays.asList("aaaaa", "dumbledore", "poppai"));
		});
	}

	@DisplayName("자동차의 이름 중복시 예외 처리 작업을 수행")
	@Test
	void checkDuplicatedCarName() {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationService.checkDuplicatedCarName(Arrays.asList("John", "Eddy", "Eddy"));
		});
	}

	@DisplayName("경주할 자동차들이 이동을 시도할 횟수의 예외 처리 작업을 수행")
	@ParameterizedTest
	@ValueSource(strings = {"", "-1", "0", "1000000000000000"})
	void checkTryNumber(String tryNumber) {
		assertThrows(IllegalArgumentException.class, () -> {
			ValidationService.checkTryNumberIsValid(tryNumber);
		});
	}
}