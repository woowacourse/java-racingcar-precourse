package racingcar.race;

import racingcar.Constant;
import racingcar.car.ParticipatingCars;

import java.util.List;
import java.util.Scanner;

public class RaceController {
    private ParticipatingCars cars;
    private RaceService raceService;
    private int raceRound;
    private int leadPosition = 0;

    public RaceController() {
        this.cars = new ParticipatingCars();
        this.raceService = new RaceService();
    }

    public void generateCars(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String[] allCarName = raceService.getAllCarName(scanner);
                raceService.carRegistration(cars, allCarName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setRaceRound(Scanner scanner) {
        while (true) {
            System.out.println(Constant.RACE_NUMBER_INPUT_MESSAGE);

            try {
                raceRound = raceService.getRaceRound(scanner);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void start() {
        System.out.println(Constant.RACE_PROCESS);

        for (int i = 0; i < raceRound; i++) {
            this.leadPosition = raceService.driveCar(cars, leadPosition);
            raceService.showCurrentSituation(cars);
        }
    }

    public void showWinner() {
        List<String> winners = raceService.findWinner(cars, leadPosition);
        raceService.printWinner(winners);
    }
}
