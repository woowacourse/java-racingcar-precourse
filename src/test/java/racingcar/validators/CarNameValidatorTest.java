package racingcar.validators;

import org.junit.jupiter.api.Test;
import racingcar.exceptions.CompletelyBlankCarNameException;
import racingcar.exceptions.PartiallyBlankCarNameException;
import racingcar.exceptions.TooLongCarNameException;
import utils.StringConverter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarNameValidatorTest {
    @Test
    public void 올바른_자동차이름_입력시_예외_발생안함() {
        //given
        String rawCarNames = "heon,fobi,woni";
        List<String> carNames = StringConverter.toListSplitByComma(rawCarNames);

        //when & then
        assertDoesNotThrow(() -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    public void 자동차이름들로_개행문자_입력시_예외_발생() {
        //given
        String rawCarNames = "\n";
        List<String> carNames = StringConverter.toListSplitByComma(rawCarNames);

        //when & then
        assertThatExceptionOfType(CompletelyBlankCarNameException.class)
                .isThrownBy(() -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    public void 자동차이름에_공백_입력시_예외_발생() {
        //given
        String rawCarNames = "heon,  ,fobi";
        List<String> carNames = StringConverter.toListSplitByComma(rawCarNames);

        //when & then
        assertThatExceptionOfType(PartiallyBlankCarNameException.class)
                .isThrownBy(() -> CarNameValidator.validateCarNames(carNames));
    }

    @Test
    public void 자동차이름이_다섯글자_초과시_예외_발생() {
        //given
        String rawCarNames = "Imheon,fobi";
        List<String> carNames = StringConverter.toListSplitByComma(rawCarNames);

        //when & then
        assertThatExceptionOfType(TooLongCarNameException.class)
                .isThrownBy(() -> CarNameValidator.validateCarNames(carNames));
    }
}