package racingcar;

import utils.Printer;
import utils.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class CarRacingGame {
    private CarList carList;
    private int raceRound;
    private Validator validator;

    public CarRacingGame() {
        carList = new CarList();
        raceRound = 0;
        validator = new Validator();
    }

    public void inputInfoForPlayGame(Scanner scanner)
    {
        carList.setCarList(inputRaceCar(scanner));
        raceRound = inputPlayRound(scanner);
    }

    private List<String> inputRaceCar(Scanner scanner) {
        try {
            Printer.setCarPrint();
            List<String> carList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
            validator.isValidCarName(carList);
            return carList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputRaceCar(scanner);
        }
    }

    private int inputPlayRound(Scanner scanner) {
        try {
            Printer.setPlayRoundPrint();
            String playRound = scanner.nextLine();
            validator.isPlayRoundInteger(playRound);
            return Integer.parseInt(playRound);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayRound(scanner);
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
        Printer.carRaceWinnerPrint(String.join(",", winners));
    }
}
