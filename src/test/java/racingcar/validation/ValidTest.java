package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.validation.ExceptionCase.*;

public class ValidTest {
    private final String NORMAL_CASE = "pobi,woni,jun";

    @Test
    void 예외_문자_입력_정상() {
        assertThatNoException()
                .isThrownBy(() -> Validation.isCommaOrAlphabet(NORMAL_CASE));
    }

    @Test
    void 숫자_입력_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isCommaOrAlphabet(CONTAIN_NUMBER.getContent()))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 공백_입력_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isCommaOrAlphabet(CONTAIN_SPACE.getContent()))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 공백_시작_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isCommaOrAlphabet(START_WITH_SPACE.getContent()))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 점_입력_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isCommaOrAlphabet(CONTAIN_DOT.getContent()))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 입력_길이_정상() {
        assertThatNoException()
                .isThrownBy(() -> Validation.isProperLength(NORMAL_CASE));
    }


    @Test
    void 입력_길이_초과_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isProperLength(EXCEED_LENGTH.getContent()))
                .withMessageStartingWith("[ERROR]");
    }


    @Test
    void 입력_길이_부족_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isProperLength(LACK_LENGTH.getContent()))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 중복된_이름_없음_정상() {
        assertThatNoException()
                .isThrownBy(() -> Validation.hasDuplicatedName(NORMAL_CASE));
    }

    @Test
    void 중복된_이름_발견_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.hasDuplicatedName(DUPLICATED.getContent()))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 시도횟수_숫자_입력() {
        assertThatNoException()
                .isThrownBy(() -> Validation.isNumber("3"));
    }

    @Test
    void 시도횟수_숫자_외_다른_문자_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.isNumber("a"))
                .withMessageStartingWith("[ERROR]");
    }

    @Test
    void 시도횟수_0_입력_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validation.firstIsZero("0"))
                .withMessageStartingWith("[ERROR]");
    }
}
