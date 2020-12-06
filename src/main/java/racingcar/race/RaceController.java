package racingcar.race;

import racingcar.Constant;
import racingcar.car.ParticipatingCars;

import java.util.List;
import java.util.Scanner;

public class RaceController {
    private ParticipatingCars cars;
    private RacePreparation racePreparation;
    private RaceProcess raceProcess;
    private RaceResult raceResult;
    private int raceRound;
    private int leadPosition = 0;

    public RaceController() {
        this.cars = new ParticipatingCars();
        this.racePreparation = new RacePreparation();
        this.raceProcess = new RaceProcess();
        this.raceResult = new RaceResult();
    }

    public void generateCars(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String[] allCarName = racePreparation.getAllCarName(scanner);
                racePreparation.carRegistration(cars, allCarName);
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
                raceRound = racePreparation.getRaceRound(scanner);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void start() {
        System.out.println(Constant.RACE_PROCESS);

        for (int i = 0; i < raceRound; i++) {
            this.leadPosition = raceProcess.driveCar(cars, leadPosition);
            raceProcess.showCurrentSituation(cars);
        }
    }

    public void showWinner() {
        List<String> winners = raceResult.findWinner(cars, leadPosition);
        raceResult.printWinner(winners);
    }
}
