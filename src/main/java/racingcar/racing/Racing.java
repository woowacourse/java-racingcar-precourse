package racingcar.racing;

import racingcar.Car;
import racingcar.garage.Garage;
import racingcar.io.FixedString;
import racingcar.io.IOService;

import java.util.ArrayList;
import java.util.List;

import static racingcar.io.FixedString.*;

public class Racing {
    private static final String BY = ",";

    public static void run() {
        IOService.ask(ASK_CAR_NAMES);
        Garage garage = Garage.from(getCarListFromString(IOService.readCarNames()));

        IOService.ask(ASK_ROUND_COUNT);
        int roundCount = IOService.readRoundCount();

        IOService.makeNewLine();
        IOService.ask(SHOW_RESULT);
        doRace(garage, roundCount);

        IOService.ask(WINNER);
        IOService.printRacingResult(garage);
    }

    private static List<Car> getCarListFromString(String carNames) {
        List<Car> carList = new ArrayList<>();

        for(String eachName : carNames.split(BY)) {
            carList.add(Car.from(eachName));
        }

        return carList;
    }

    private static void doRace(Garage garage, int roundCount) {
        for(int i = 0; i < roundCount; i++) {
            garage.playAll();
            IOService.printEachRoundResult(garage);
            IOService.makeNewLine();
        }
    }
}
