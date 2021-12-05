package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;
import racingcar.resource.message.ErrorMessage;

class ExecutionCountInputErrorTest extends NsTest {

    @Test
    void 이동횟수_문자입력_예외처리() {
        String errorMessage = ErrorMessage.TAG + ErrorMessage.COUNT_NOT_NUMBER_MESSAGE;
        assertSimpleTest(
            () -> {
                runException("pobi,woni", "a");
                List<String> outputStrings = Arrays.asList(output().split("\n"));
                assertThat(outputStrings.size()).isEqualTo(3);
                assertThat(outputStrings.get(2)).isEqualTo(errorMessage);
            }
        );
    }
    @Test
    void 이동횟수_음수입력_예외처리() {
        String errorMessage = ErrorMessage.TAG + ErrorMessage.COUNT_TOO_SMALL_MESSAGE;
        assertSimpleTest(
            () -> {
                runException("pobi,woni", "-1");
                List<String> outputStrings = Arrays.asList(output().split("\n"));
                assertThat(outputStrings.size()).isEqualTo(3);
                assertThat(outputStrings.get(2)).isEqualTo(errorMessage);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
