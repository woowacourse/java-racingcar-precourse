package view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConsoleViewTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static ConsoleView consoleView;

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("콘솔 뷰의 출력을 확인")
    @Test
    public void 출력_테스트(){
        consoleView = new ConsoleView(new Scanner(System.in));

        String testWords = "Hello World!";
        consoleView.println(testWords);

        String expectedResult = testWords + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedResult);
    }

    @DisplayName("콘솔 뷰의 입력을 확인")
    @Test
    public void 입력_테스트() {
        String inputString = "Hello World!";
        consoleView = makeIncludingStringConsoleView(inputString);

        assertThat(consoleView.inputNextLine()).isEqualTo(inputString);
    }

    @DisplayName("숫자가 아닌 값이 입력되면 오류가 나는지 확인")
    @Test
    void inputNextInt() {
        String inputString = "A";
        consoleView = makeIncludingStringConsoleView(inputString);

        assertThatThrownBy(() -> consoleView.inputNextInt()).isInstanceOf(IllegalArgumentException.class);
    }

    ConsoleView makeIncludingStringConsoleView(String inputString){
        byte[] byteArrray = inputString.getBytes();
        ByteArrayInputStream inputData = new ByteArrayInputStream(byteArrray);
        return new ConsoleView(new Scanner(inputData));
    }
}