import io.IoSystem;

import controll.Controller;
import domain.Car;

class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        IoSystem iosystem = new IoSystem();
        iosystem.printCarList();
        controller.stringCommaSplit(iosystem.inputCarList());
        iosystem.printCount();
        iosystem.inputCount();

        iosystem.printResult();
        for (int i = 0; i < iosystem.getCount(); i++) {
            controller.runCarsForward();
            controller.runCarsPirnt();
        }
        controller.getMaximumDistanceCar();
        iosystem.printResultCars();
    }
}