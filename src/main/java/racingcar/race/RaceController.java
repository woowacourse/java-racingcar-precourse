package racingcar.race;

import racingcar.Constant;
import racingcar.car.ParticipatingCars;
import racingcar.round.Round;

import java.util.List;
import java.util.Scanner;

public class RaceController {
    private ParticipatingCars cars;
    private RacePreparation racePreparation;
    private RaceProcess raceProcess;
    private RaceResult raceResult;
    private Round round;
    private int leadPosition = 0;

    public RaceController() {
        this.racePreparation = new RacePreparation();
        this.raceProcess = new RaceProcess();
        this.raceResult = new RaceResult();
    }

    public void generateCars(Scanner scanner) {
        while (true) {
            System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);

            try {
                String[] allCarName = racePreparation.getAllCarName(scanner);
                this.cars = new ParticipatingCars(allCarName);
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
                String number = racePreparation.getRaceRound(scanner);
                this.round = new Round(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void start() {
        System.out.println(Constant.RACE_PROCESS);

        for (int i = 0; i < round.getRound(); i++) {
            this.leadPosition = raceProcess.driveCar(cars, leadPosition);
            raceProcess.showCurrentSituation(cars);
        }
    }

    public void showWinner() {
        List<String> winners = raceResult.findWinner(cars, leadPosition);
        raceResult.printWinner(winners);
    }
}
