package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.exception.NameDuplicateMessageException;
import racingcar.exception.NameEmptyMessageException;
import racingcar.exception.NameTooLongMessageException;

public class CarNameInputTest {

    private final CustomReader customReader = new CustomReader();
    private final InputView inputView = new InputView(customReader);

    @Test
    void 자동차이름_입력기능_작동확인() {
        List<String> answers = Arrays.asList("하나", "둘", "셋");
        String inputString = String.join(",", answers);
        customReader.initInputString(inputString);

        List<String> carNames = inputView.getNames();

        assertThat(carNames.size()).isEqualTo(answers.size());

        for (int i = 0; i < carNames.size(); i++) {
            assertThat(carNames.get(i)).isEqualTo(answers.get(i));
        }
    }

    @Test
    void 자동차이름_중복입력시_예외발생() {
        String inputString =  "하나,둘,셋,하나";
        customReader.initInputString(inputString);

        assertThrows(NameDuplicateMessageException.class, () -> {
            List<String> carNames = inputView.getNames();
        });
    }

    @Test
    void 자동차이름_공백입력시_예외발생() {
        String inputString =  "하나, ,셋";
        customReader.initInputString(inputString);

        assertThrows(NameEmptyMessageException.class, () -> {
            List<String> carNames = inputView.getNames();
        });
    }

    @Test
    void 자동차이름_길이초과입력시_예외발생() {
        String inputString =  "하나,둘,셋,아이고길어라껄껄";
        customReader.initInputString(inputString);

        assertThrows(NameTooLongMessageException.class, () -> {
            List<String> carNames = inputView.getNames();
        });
    }

}
