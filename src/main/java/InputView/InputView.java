package InputView;

import java.util.List;
import java.util.Scanner;

public class InputView {
    int VALID_MINIMUM_INPUT_LENGTH = 2;
    private final Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }



    private boolean isValidInput(String inputCarNames){
        if(inputCarNames.length() < VALID_MINIMUM_INPUT_LENGTH) {
            return false;
        }
        return true;
    }

}
