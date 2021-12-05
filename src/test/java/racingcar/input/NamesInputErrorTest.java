package racingcar.input;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.Application;
import racingcar.resource.message.ErrorMessage;

class NamesInputErrorTest extends NsTest {

    @Test
    void 이름_중복입력_예외처리() {
        String errorMessage = ErrorMessage.TAG + ErrorMessage.NAME_DUPLICATE_MESSAGE;
        assertSimpleTest(
            () -> {
                runException("pobi,java,pobi");
                List<String> outputStrings = Arrays.asList(output().split("\n"));
                assertThat(outputStrings.size()).isEqualTo(2);
                assertThat(outputStrings.get(1)).isEqualTo(errorMessage);
            }
        );
    }
    @Test
    void 이름_공백입력_예외처리() {
        String errorMessage = ErrorMessage.TAG + ErrorMessage.NAME_EMPTY_MESSAGE;
        assertSimpleTest(
            () -> {
                runException("pobi, ,hello");
                List<String> outputStrings = Arrays.asList(output().split("\n"));
                assertThat(outputStrings.size()).isEqualTo(2);
                assertThat(outputStrings.get(1)).isEqualTo(errorMessage);
            }
        );
    }

    @Test
    void 이름_길이초과입력_예외처리() {
        String errorMessage = ErrorMessage.TAG + ErrorMessage.NAME_TOO_LONG_MESSAGE;
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                List<String> outputStrings = Arrays.asList(output().split("\n"));
                assertThat(outputStrings.size()).isEqualTo(2);
                assertThat(outputStrings.get(1)).isEqualTo(errorMessage);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
