package racingcar;

import java.util.List;

public class Controller {
    private final View view = new View();
    private final Service service = new Service();

    public void racingCar() {
        Car[] cars = null;
        int count = 0;
        String inputNames = "";
        String inputCount = "";

        while (true) {
            try {
                view.printCarsManual();
                inputNames = view.input();
                cars = service.saveCars(inputNames);
                break;
            } catch (IllegalArgumentException e) {
                view.printError("잘못된 인자가 입력됨");
            }
        }

        while (true) {
            try {
                view.printCountManual();
                inputCount = view.input();
                count = service.changeCount(inputCount);
                break;
            } catch (IllegalArgumentException e) {
                view.printError("잘못된 인자가 입력됨");
            }
        }

        view.printResultManual();
        for (int i = 0; i < count; i++) {
            service.doRace(cars);
            view.printScore(cars);
        }

        String winners = service.findWinners(cars);
        view.printWinner(winners);

    }
}
