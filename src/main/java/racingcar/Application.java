package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;
import racingcar.domain.race.RaceSetting;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView inputView = InputView.of(scanner);
        OutputView outputView = OutputView.basic();

        repeatingUntilNoException(() -> start(inputView, outputView));
    }

    @SuppressWarnings("unchecked")
    private static void start(final InputView inputView, final OutputView outputView) {
        List<Car> cars = (List<Car>) repeatingUntilNoException(() -> {
            outputView.printInputCarNamesMessage();
            return RaceSetting.convertToCars(inputView.readCarNames());
        });

        int movingCount = (int) repeatingUntilNoException(() -> {
            outputView.printInputMovingCountMessage();
            return inputView.readMovingCount();
        });

        Race race = RaceSetting.makeRace(cars, movingCount);
        race(race, outputView);
        outputView.printWinnerCars(race);
    }

    private static void race(final Race race, final OutputView outputView) {
        outputView.printResultMessage();
        outputView.printRaceTrack(race);

        while (!race.isComplete()) {
            race.move();
            outputView.printRaceTrack(race);
        }
    }

    private static Object repeatingUntilNoException(final Supplier<Object> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void repeatingUntilNoException(final SupplierNoReturn supplierNoReturn) {
        while (true) {
            try {
                supplierNoReturn.execute();
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
