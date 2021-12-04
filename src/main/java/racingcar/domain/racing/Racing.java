package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.garage.Garage;
import racingcar.io.IOService;

import java.util.ArrayList;
import java.util.List;

import static racingcar.io.FixedString.*;

public class Racing {
    private static final String BY = ",";

    public static void run() {
        Garage garage = getGarage();
        int roundCount = getRoundCount();

        IOService.makeNewLine();
        IOService.ask(SHOW_RESULT);

        doRace(garage, roundCount);

        IOService.ask(WINNER);
        IOService.printRacingResult(garage);
    }

    private static Garage getGarage() {
        IOService.ask(ASK_CAR_NAMES);
        String carNames;

        while (true) {
            try {
                carNames = IOService.readCarNames();
                break;
            } catch (IllegalArgumentException e) {
                IOService.printErrorMessage(e.getMessage());
                continue;
            }
        }

        return Garage.from(getCarListFromString(carNames));
    }

    private static int getRoundCount() {
        IOService.ask(ASK_ROUND_COUNT);

        int roundCount;

        while (true) {
            try {
                roundCount = IOService.readRoundCount();
                break;
            } catch (IllegalArgumentException e) {
                IOService.printErrorMessage(e.getMessage());
                continue;
            }
        }

        return roundCount;
    }

    private static List<Car> getCarListFromString(String carNames) {
        List<Car> carList = new ArrayList<>();

        for (String eachName : carNames.split(BY)) {
            carList.add(Car.from(eachName));
        }

        return carList;
    }

    private static void doRace(Garage garage, int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            garage.playAll();
            IOService.printEachRoundResult(garage);
            IOService.makeNewLine();
        }
    }
}
