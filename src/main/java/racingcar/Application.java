package racingcar;

import View.InputView;
import error.Validator;
import error.customException.NotValidInputException;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws NotValidInputException {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        try {
            String inputLine = InputView.inputCarName(scanner).trim();
            Validator.validateCarNameInSingleLine(inputLine);
        } catch ( NotValidInputException e ) {
            e.printStackTrace();
        }
    }

}
