package View;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final int VALID_MINIMUM_CAR_NAMES_LENGTH = 2;
    private final String ERROR_TAG = "[Error]";
    private final String INVAlID_INPUT_LENGTH = "You should input at least one car name";

    private final Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCarNames() {
        String carNames = this.scanner.nextLine();

        if(!isValidInput(carNames)) {
            Exception e = new Exception(ERROR_TAG + INVAlID_INPUT_LENGTH);
            System.out.println(e.toString());
        }

        return this.ConvertToList(carNames);
    }

    private List<String> ConvertToList(String target) {
        return Arrays.asList(target.split(","));
    }

    private boolean isValidInput(String inputCarNames) {
        if(inputCarNames.length() < VALID_MINIMUM_CAR_NAMES_LENGTH) {
            return false;
        }
        return true;
    }

}
