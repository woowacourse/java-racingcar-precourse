package racingcar;

import java.util.*;
import java.util.stream.Collectors;

import utils.InputPrinter;
import utils.OutPutPrinter;
import utils.Validator;

public class CarRacingGame {
    private static final int INITIAL_VALUE = 0;
    private static final String COMMA = ",";

    private CarList carList;
    private int raceRound;
    private Validator validator;

    public CarRacingGame() {
        carList = new CarList();
        raceRound = INITIAL_VALUE;
        validator = new Validator();
    }

    public void inputInfoForPlayGame(Scanner scanner)
    {
        carList.setCarList(inputRaceCar(scanner));
        raceRound = inputRaceRound(scanner);
    }

    private List<String> inputRaceCar(Scanner scanner) {
        try {
            InputPrinter.inputCarPrint();
            List<String> carList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(COMMA)));
            validator.isValidCarNameSize(carList);
            return carList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputRaceCar(scanner);
        }
    }

    private int inputRaceRound(Scanner scanner) {
        try {
            InputPrinter.inputRaceRoundPrint();
            String raceRound = scanner.nextLine();
            validator.isRaceRoundInteger(raceRound);
            return Integer.parseInt(raceRound);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputRaceRound(scanner);
        }
    }

    public void startCarRacing() {
        Race race = new Race(carList, raceRound);
        race.runCarRace();
    }

    public void carRaceWinner() {
        List<Car> raceDoneCarList = carList.getCarList();
        List<Car> sortedCarList = raceDoneCarList.stream()
                .sorted((a, b) -> b.getPosition() - a.getPosition())
                .collect(Collectors.toList());

        List<String> winners = new ArrayList<>();
        int maxPosition = sortedCarList.get(0).getPosition();
        for (Car car : sortedCarList) {
            if (maxPosition == car.getPosition()) {
                winners.add(car.getName());
            }
        }
        OutPutPrinter.carRaceWinnerPrint(String.join(COMMA, winners));
    }
}
