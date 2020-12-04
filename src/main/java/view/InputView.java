package view;

import racingcar.Cars;
import racingcar.Rounds;
import utils.CarsFactory;

import java.util.Scanner;

public class InputView {
    private static final String NAME_DELIMITER = ",";

    private InputView(){}

    public static Cars getNames(Scanner scanner){
        OutputView.printMsg("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)\n");
        String[] names = getInput(scanner).split(NAME_DELIMITER);
        return CarsFactory.createCars(names);
    }

    public static Rounds getRounds(Scanner scanner){
        OutputView.printMsg("시도할 횟수\n");
        int tryNumber = Integer.parseInt(getInput(scanner));
        return Rounds.initialize(tryNumber);
    }

    public static String getInput(Scanner scanner){
        return scanner.nextLine();
    }
}
