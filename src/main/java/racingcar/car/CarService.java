package racingcar.car;

import utils.RandomGenerator;

public class CarService {

    public static final int GO_FORWARD_STANDARD = 4;
    public static final int GO_FORWARD_DISTANCE = 1;

    private final CarRepository carRepository;

    private CarService() {
        carRepository = CarRepository.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final CarService instance = new CarService();
    }

    public static CarService getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void createCar(String name) {
        carRepository.createCar(new Car(name));
    }

    public void moveForward() {
        int carCount = carRepository.getCarCount();
        for(int i = 0; i < carCount; ++i) {
            if(isMove()) {
                carRepository.moveForward(i);
            }
        }
    }

    private boolean isMove() {
        int randomNumber = RandomGenerator.create();
        return randomNumber >= GO_FORWARD_STANDARD;
    }
}