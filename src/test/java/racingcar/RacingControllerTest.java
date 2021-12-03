package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class RacingControllerTest {
    private final InputStream standardIn = System.in;
    private final RacingController racingController = new RacingController();

    @Test
    void 자동차_이름을_쉼표를_구분자로_입력받음() {
        String[] carNames = new String[]{"pobi", "woni", "jun"};
        String input = "pobi,woni,jun";
        setInput(input);
        assertThat(racingController.inputCarNames()).isEqualTo(carNames);
    }

    @Test
    void 자동차_이름이_쉼표만_들어왔을_경우_예외_발생() {
        String input = ",";
        setInput(input);
        assertThatThrownBy(racingController::inputCarNames).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_공백이_들어왔을_경우_예외_발생() {
        String input = " ";
        setInput(input);
        assertThatThrownBy(racingController::inputCarNames).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 회차_수를_정수로_입력() {
        String input = "1";
        setInput(input);
        assertThat(racingController.inputRoundNumber()).isEqualTo(1);
    }

    @Test
    void 회차_수가_정수가_아닐_경우_예외_발생() {
        String input = "!";
        setInput(input);
        assertThatThrownBy(racingController::inputRoundNumber).isInstanceOf(IllegalArgumentException.class);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void 표준_인풋_스트림으로_복구() {
        System.setIn(standardIn);
    }
}
