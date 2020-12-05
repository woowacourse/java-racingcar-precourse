import static org.junit.jupiter.api.Assertions.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Request;

class RequestTest {
    PrintStream printStream = new PrintStream(System.out);

    @Test
    void testRequestCarNames() {
        String[] correctInputs = {"pobi,woni,jun", "root,pobi,jun", "a,b,c"};
        String[] faultInputs = {",woni,jun", "pobi,woni,junnnn", "pobi,woni,pobi", "woni,jun,", ",,,,"};
        String[][] outputs = {{"pobi", "woni", "jun"}, {"root", "pobi", "jun"}, {"a", "b", "c"}};
        
        for (int inputIndex = 0; inputIndex < correctInputs.length; inputIndex++) {
            Scanner scanner = new Scanner(correctInputs[inputIndex]);
            Request request = new Request(scanner, printStream);
            
            ArrayList<Car> cars = request.requestCarNames();
            for (int i = 0; i < outputs.length; i++) {
                assertEquals(outputs[inputIndex][i], cars.get(i).getCarName());
            }
        }
        
        for (String input : faultInputs) {
            Scanner scanner = new Scanner(input);
            Request request = new Request(scanner, printStream);
            try {
                request.requestCarNames();
                String message = String.format("%s는 IllegalArgumentException가 발생해야됩니다.", input);
                fail(message);
            } catch (IllegalArgumentException iae) {
            }
        }
    }

}
