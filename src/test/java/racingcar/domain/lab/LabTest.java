package racingcar.domain.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LabTest {

	@Test
	public void 시도_횟수는_숫자여야_한다() {
		for (String actual : new String[] {"일", "-1", ""}) {
			assertThrows(LabMustBeNumberException.class, () -> new Lab(actual));
		}
	}

	@Test
	public void 시도_횟수는_INT여야_한다() {
		assertThrows(LabMustIntegerRangeException.class, () -> new Lab("2147483648"));
	}

	@ParameterizedTest
	@CsvSource({"10,00,0,1234"})
	public void 시도_횟수를_만들_수_있다(String actual) {
		assertDoesNotThrow(() -> new Lab(actual));
	}

}