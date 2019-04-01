package woowacourse.second;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class CarRacingGameTest {
	
	CarRacingGame test;
	Method validInput;
	
	@Before
	public void init() throws NoSuchMethodException, SecurityException {
		test = new CarRacingGame();
		validInput = CarRacingGame.class.getDeclaredMethod("validInput", String.class);
		validInput.setAccessible(true);
	}
	
	@Test
	public void valid_input_value() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String correctInput = "pobi,crong,honux";
		assertThat(validInput.invoke(test, correctInput)).isEqualTo(true);
		String correctInput2 = "pobi";
		assertThat(validInput.invoke(test, correctInput2)).isEqualTo(true);
	}
	
	@Test
	public void wrong_input_value() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String wrongInput = "pobi,crong,";
		assertThat(validInput.invoke(test, wrongInput)).isEqualTo(false);
		String wrongInput2 = "wrongInput";
		assertThat(validInput.invoke(test, wrongInput2)).isEqualTo(false);
	}
}
