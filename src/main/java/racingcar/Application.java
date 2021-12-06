package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.io.ConsolePrinter;
import racingcar.io.ConsoleReader;

public class Application {

    private static final String READ_CARS_STRING_DELIMITER = ",";

    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();
        ConsoleReader writer = new ConsoleReader(printer);
        List<Car> racers = readRacers(writer, printer);
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

}
