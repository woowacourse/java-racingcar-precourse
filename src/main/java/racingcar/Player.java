package racingcar;

import utils.Printer;
import utils.Validator;
import java.util.*;

public class Player {
    private  Validator validator = new Validator();

    public CarRacingGame inputInfoForPlayGame(Scanner scanner)
    {
        try {
            Printer.setCarNamePrinter();
            List<String> carList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
            validator.isValidCarName(carList);
            Printer.setPlayRoundPrinter();
            String playRound = scanner.nextLine();
            validator.isPlayRoundInteger(playRound);
            return new CarRacingGame(carList, Integer.parseInt(playRound));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return inputInfoForPlayGame(scanner);
        }
    }
}
