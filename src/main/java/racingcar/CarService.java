package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static util.CarConstant.*;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public void saveCars(String input){
        String[] tempCars = input.split(DELIMITER);
        CarValidator.isNameLowerThanFive(tempCars);
        carRepository.saveAll(createCarList(tempCars));
    }

    private List<Car> createCarList(String[] tempCars) {
        return Arrays.asList(tempCars)
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void updateCarPosition(){
        List<Car> cars = carRepository.findAll();
        for (Car car : cars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        if(checkMoveForward()){
            car.goForward();
        }
    }

    private boolean checkMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
        if(randomNumber >= 4){
            return true;
        }
        return false;
    }

    public List<Car> findAllCar(){
        return carRepository.findAll();
    }

    public List<Car> findWinners(){
        List<Car> findCars = carRepository.findAll();
        int maxPosition = findMaxPosition(findCars);

        return findCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition(List<Car> findCars) {
        int max = 0;
        for (Car findCar : findCars) {
            if(findCar.getPosition() > max){
                max = findCar.getPosition();
            }
        }
        return max;
    }

}
