package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    private final static String CAR_NAME_SEPARATOR = ",";
    private Printer printer = new Printer();
    private Validator validator = new Validator();

    public List<String> inputCarNames() {
        List<String> names = new ArrayList<>();

        while(names.isEmpty()){
            try {
                String carNames = Console.readLine();
                validator.validateCarName(carNames);
                names = Arrays.asList(carNames.split(CAR_NAME_SEPARATOR));

            } catch (Exception exception) {
                printer.printException(exception);
            }
        }

        return names;
    }

    public int inputRoundNumber() {
        int round = 0;

        while(round == 0){
            try {
                String roundNumber = Console.readLine();
                validator.validateRoundNumber(roundNumber);
                round = Integer.parseInt(roundNumber);

            } catch (Exception exception) {
                printer.printException(exception);
            }
        }

        return round;
    }
}
