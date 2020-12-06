package racingcar.race;

import racingcar.Constant;
import racingcar.car.Car;

import java.util.List;
import java.util.Scanner;

public class RaceController {
    private List<Car> allRacingCars;
    private RaceService raceService;
    private int raceRound;
    private int leadPosition = 0;

    public RaceController() {
        this.raceService = new RaceService();
    }

    public void generateCars(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String[] cars = raceService.getAllCarName(scanner);
                allRacingCars = raceService.carRegistration(cars);
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
            this.leadPosition = raceService.driveCar(allRacingCars, this.leadPosition);
            raceService.showCurrentSituation(allRacingCars);
        }
    }

    public void showWinner() {
        List<String> winners = raceService.findWinner(allRacingCars, leadPosition);
        raceService.printWinner(winners);
    }
}
