package racingcar.inputvalue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNamesInputValueTest {

    @Test
    void 자동차_이름을_쉼표를_구분자로_입력받음() {
        String input = "pobi,woni,jun";
        String[] carNames = new String[]{"pobi", "woni", "jun"};
        InputValue<String[]> carNameInputValue = new CarNamesInputValue(input);

        assertThat(carNameInputValue.toRacingElement()).isEqualTo(carNames);
    }

    @Test
    void 자동차_이름이_쉼표만_들어왔을_경우_예외_발생() {
        String comma = ",";
        InputValue<String[]> carNameInputValue = new CarNamesInputValue(comma);

        assertThatThrownBy(carNameInputValue::toRacingElement).isInstanceOf(IllegalArgumentException.class);
    }
}
