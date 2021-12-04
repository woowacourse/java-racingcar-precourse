package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import racingcar.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;

public class CarServiceImpl implements CarService {

	private final CarRepository carRepository;

	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void join(String name) {
		carRepository.save(new Car(name));
	}

	@Override
	public Car findCar(int carId) {
		return carRepository.findById(carId);
	}

	@Override
	public void moveAllCars() {
		Map<Integer, Car> cars = carRepository.findAll();
		for (int carId : cars.keySet()) {
			String carName = findCar(carId).getName();
			int carPosition = findCar(carId).move();
			System.out.print(carName + " : ");
			for (int i = 0; i < carPosition; i++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}

	@Override
	public List<Car> findWinningCars() {
		Map<Integer, Car> cars = carRepository.findAll();
		int maxPosition = carRepository.findMaxPosition();
		List<Car> winningCars = new ArrayList<>();
		for (int carId : cars.keySet()) {
			Car car = findCar(carId);
			if (car.getPosition() == maxPosition) {
				winningCars.add(car);
			}
		}
		return winningCars;
	}
}