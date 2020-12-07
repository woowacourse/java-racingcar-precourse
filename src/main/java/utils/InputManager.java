package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_ROUND_INPUT = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";

    private final Validator validator;
    private final Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
        validator = new Validator();
    }

    public List<String> inputRaceCar() {
        try {
            System.out.println(CAR_NAME_INPUT);
            List<String> carList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(COMMA)));
            validator.isValidCarsInput(carList);
            return carList;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputRaceCar();
        }
    }

    public int inputRaceRound() {
        try {
            System.out.println(RACE_ROUND_INPUT);
            String raceRound = scanner.nextLine();
            validator.isValidRaceRoundInput(raceRound);
            return Integer.parseInt(raceRound);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return inputRaceRound();
        }
    }
}
