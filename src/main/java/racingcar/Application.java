package racingcar;

import racingcar.domain.car.CarInterface;
import racingcar.domain.car.carfactory.CarFactory;
import racingcar.domain.car.carfactory.Factory;
import racingcar.domain.car.carmanager.CarManager;
import racingcar.view.View;

import java.util.List;
import java.util.Scanner;

public class Application {
    private View view;

    public Application(Scanner scanner) {
        view = new View(scanner);
    }

    public void run() {
        try {
            List<String> carNames = view.askCarNames();
            int trialCount = view.askTrialCount();

            Factory carFactory = new CarFactory();
            CarManager carManager = new CarManager(carFactory);

            List<CarInterface> cars = carManager.orderCar(carNames);
            for (int currentTrialCount = 0; currentTrialCount < trialCount; currentTrialCount++) {
                carManager.driveAllCarOnce();
                view.printCurrentPosition(cars);
            }

            view.printWinner(carManager.getHeadCars());
        } catch (Exception e) {
            view.printError(e.getMessage());
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        Application application = new Application(scanner);
        application.run();
    }
}
