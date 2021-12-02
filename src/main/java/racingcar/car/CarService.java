package racingcar.car;

import racingcar.car.dto.CarDto;
import utils.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getWinner() {
        List<CarDto> carDtos = getDescendingOrderByPosition();
        int maxPosition = carDtos.get(0).getPosition();

        return carDtos.stream()
                .filter(carDto -> carDto.isSamePosition(maxPosition))
                .map(CarDto::getName)
                .collect(Collectors.toList());
    }

    public List<CarDto> getDescendingOrderByPosition() {
        List<CarDto> carDtoList = carRepository.getCars();
        carDtoList.sort((a, b) -> b.getPosition() - a.getPosition());
        return carDtoList;
    }

    public List<CarDto> getCars() {
        return carRepository.getCars();
    }
}