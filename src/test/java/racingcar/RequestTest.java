package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class RequestTest {
    private static final String FAIL_MESSAGE_FORMAT = "%s는 IllegalArgumentException가 발생해야됩니다.";
    private static final PrintStream printStream = new PrintStream(System.out);

    @Test
    void testRequestCarNames() {
        String[] correctInputs = {"pobi,woni,jun", "root,pobi,jun", "a,b,c"};
        String[] faultInputs =
                {",woni,jun", "pobi,woni,junnnn", "pobi,woni,pobi", "woni,jun,", ",,,,", "\n"};
        String[][] expectedOutputs =
                {{"pobi", "woni", "jun"}, {"root", "pobi", "jun"}, {"a", "b", "c"}};

        testCorrectRequestCarNames(correctInputs, expectedOutputs);
        testFaultRequestCarNames(faultInputs);
    }

    private void testCorrectRequestCarNames(String[] correctInputs, String[][] expectedOutput) {
        for (int inputIndex = 0; inputIndex < correctInputs.length; inputIndex++) {
            Scanner scanner = new Scanner(correctInputs[inputIndex]);
            Request request = new Request(scanner, printStream);
            ArrayList<Car> cars = request.requestCarNames();
            for (int i = 0; i < expectedOutput.length; i++) {
                assertEquals(expectedOutput[inputIndex][i], cars.get(i).getCarName());
            }
        }
    }

    private void testFaultRequestCarNames(String[] faultInputs) {
        for (String input : faultInputs) {
            Scanner scanner = new Scanner(input);
            Request request = new Request(scanner, printStream);
            try {
                request.requestCarNames();
                fail(String.format(FAIL_MESSAGE_FORMAT, input));
            } catch (IllegalArgumentException iae) {
            }
        }
    }

    @Test
    void testRequestNumberRound() {
        String[] correctInputs = {"1", "2", "+50", "2147483647"};
        String[] faultInputs = {"0", "2147483648", "-", "2-1", "abc", "984-"};

        testCorrectRequestNumberRound(correctInputs);
        testFaultReqeustNumberRound(faultInputs);
    }

    private void testCorrectRequestNumberRound(String[] correctInputs) {
        for (String input : correctInputs) {
            Scanner scanner = new Scanner(input);
            Request request = new Request(scanner, printStream);
            assertEquals(Integer.parseInt(input), request.requestNumberRound());
        }
    }

    private void testFaultReqeustNumberRound(String[] faultInputs) {
        for (String input : faultInputs) {
            Scanner scanner = new Scanner(input);
            Request request = new Request(scanner, printStream);
            try {
                request.requestNumberRound();
                fail(String.format(FAIL_MESSAGE_FORMAT, input));
            } catch (IllegalArgumentException iae) {
            }
        }
    }
}
