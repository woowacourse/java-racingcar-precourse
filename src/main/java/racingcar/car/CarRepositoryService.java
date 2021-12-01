package racingcar.car;

import racingcar.exceptions.CarListException;

public class CarRepositoryService {

	CarRepository carRepository;

	public CarRepositoryService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public void checkException(String cars) {
		String[] carArray = cars.split(",");
		CarListException.carListException(carArray);

		saveCar(carArray);
	}

	public void saveCar(String[] carArray){
		for (String carName : carArray) {
			Car car = createCarByName(carName.trim());
			carRepository.addCars(car);
		}
	}

	private Car createCarByName(String carName) {
		return new Car(carName);
	}
}
