package racingcar;

import domain.Car;
import domain.Participants;
import utils.InputView;
import utils.Printer;
import utils.RandomDigitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceManager {
    private Race race;

    private RaceManager(Race race) {
        this.race = race;
    }

    public static RaceManager from(Scanner scanner) {
        InputView inputView = new InputView(scanner);
        String[] names = inputView.inputName();
        int round = inputView.inputRound();
        Participants participants = participateRace(names);
        return new RaceManager(Race.of(participants, round));
    }

    public static RaceManager from(Participants participants, int round) {
        return new RaceManager(Race.of(participants, round));
    }

    private static Participants participateRace(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return Participants.from(cars);
    }

    public void startRandomRace() {
        RaceResult raceResult = race.startRace(new RandomDigitStrategy());
        announceResult(raceResult);
    }

    private void announceResult(RaceResult raceResult) {
        Printer.printRaceStart();
        Printer.print(raceResult.getLog());
        List<String> winnersName = raceResult.getWinnersName();
        Printer.printWinnerName(winnersName);
    }
}
