package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String COMMA = ",";
    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> enterCarNames(){
        String carNames = scanner.nextLine().trim();
        List<String> splittedCarNames = splitCarNamesByComma(carNames);
        return splittedCarNames;
    }

    public List<String> splitCarNamesByComma(String CarNames){
        return Arrays.asList(CarNames.split(","));
    }
}
