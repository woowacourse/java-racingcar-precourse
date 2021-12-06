package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.service.Referee;
import racingcar.domain.trycounter.Lab;
import racingcar.io.ConsolePrinter;
import racingcar.io.ConsoleReader;
import racingcar.runner.RacingGame;

public class Application {

    private static final String READ_CARS_STRING_DELIMITER = ",";

    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();
        ConsoleReader writer = new ConsoleReader(printer);
        List<Car> racers = readRacers(writer, printer);
        Lab lab = readLab(writer, printer);
        Referee referee = new Referee();
        RacingGame game = new RacingGame(lab, racers, printer, referee);
        game.start();
    }

    private static List<Car> readRacers(ConsoleReader reader, ConsolePrinter printer) {

        try {
            String[] racerNames = reader.readRacer().split(READ_CARS_STRING_DELIMITER);
            return Arrays.stream(racerNames)
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readRacers(reader, printer);
        }

    }

    private static Lab readLab(ConsoleReader reader, ConsolePrinter printer) {

        try {
            return new Lab(reader.readTryCount());
        } catch (IllegalArgumentException e) {
            printer.print(e.getMessage());
            return readLab(reader, printer);
        }

    }
}
