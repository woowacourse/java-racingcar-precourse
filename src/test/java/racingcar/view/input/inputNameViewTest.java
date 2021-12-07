package racingcar.view.input;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.config.ViewConfig;
import racingcar.domain.car.CarSet;
import racingcar.view.input.InputNameView;

class inputNameViewTest {

	@Test
	@DisplayName("쉼표로 구분하여 자동차 셋을 생성한다.")
	public void testCarSetConstruction() {
		// given
		String input = "a,b,c";
		// when
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		InputNameView service = ViewConfig.getInputNameView();
		CarSet carSet = service.inputNames();
		// then
		assertEquals(carSet.toString(), "a : \nb : \nc : ");
	}
}