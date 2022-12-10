package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private RaceController controller;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void outputSetUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @BeforeEach
    void initController() {
        String input = "A,B,C" + "\n" + "3";
        systemIn(input);

        this.controller = new RaceController();
    }

    @Test
    @DisplayName("경주 기능 동작 시 입력한 횟수만큼 실행되는지 확인")
    void racingLoopTest() {
        this.controller.racing();

        String output = getOutput();
        assertThat(output).contains("실행 결과");

        List<String> expectedRacingMessages = List.of("A : ", "B : ", "C : ");

        for (int i = 0; i < 3; i++) {
            for (String msg : expectedRacingMessages) {
                assertThat(output).contains(msg);
                output = output.replaceFirst(msg, "");
            }
        }

        for (String msg : expectedRacingMessages) assertThat(output).doesNotContain(msg);
    }

    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    String getOutput() {
        return outputStream.toString();
    }


}
