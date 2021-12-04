package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import racingcar.exception.CountNotNumberMessageException;
import racingcar.exception.CountTooSmallMessageException;

public class ExecutionCountInputTest {

    private final CustomReader customReader = new CustomReader();
    private final InputView inputView = new InputView(customReader);

    @Test
    void 이동횟수_입력기능_작동확인() {
        int answer = 3;
        customReader.initInputString(String.valueOf(answer));

        int executionCount = inputView.getExecutionCount();
        assertThat(executionCount).isEqualTo(answer);
    }

    @Test
    void 이동횟수_음수입력시_예외발생() {
        String inputString = "-3";
        customReader.initInputString(inputString);

        assertThrows(CountTooSmallMessageException.class, () -> {
            int executionCount = inputView.getExecutionCount();
        });
    }

    @Test
    void 이동횟수_정수가아닌값입력시_예외발생() {
        String inputString = "a";
        customReader.initInputString(inputString);

        assertThrows(CountNotNumberMessageException.class, () -> {
            int executionCount = inputView.getExecutionCount();
        });
    }

}
