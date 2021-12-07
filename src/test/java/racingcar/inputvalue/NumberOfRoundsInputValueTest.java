package racingcar.inputvalue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberOfRoundsInputValueTest {

    @Test
    void 회차를_정수로_입력() {
        String input = "1";
        int expectedResult = Integer.parseInt(input);
        InputValue<Integer> numberOfRoundsInputValue = new NumberOfRoundsInputValue(input);

        assertThat(numberOfRoundsInputValue.toRacingElement()).isEqualTo(expectedResult);
    }

    @Test
    void 회차가_정수가_아닐_경우_예외_발생() {
        String notIntInput = "300000000000000";
        InputValue<Integer> numberOfRoundsInputValue = new NumberOfRoundsInputValue(notIntInput);

        assertThatThrownBy(numberOfRoundsInputValue::toRacingElement).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 회차가_숫자가_아닐_경우_예외_발생() {
        String notDecimalInput = "!";
        InputValue<Integer> numberOfRoundsInputValue = new NumberOfRoundsInputValue(notDecimalInput);

        assertThatThrownBy(numberOfRoundsInputValue::toRacingElement).isInstanceOf(IllegalArgumentException.class);
    }
}
