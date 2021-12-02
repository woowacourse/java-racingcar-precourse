package racingcar;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController(new CarService(CarRepository.getInstance()));
        carController.play();
    }
}
