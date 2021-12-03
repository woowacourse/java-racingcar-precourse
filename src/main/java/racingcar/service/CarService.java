package racingcar.service;

import java.util.List;

import racingcar.Car;

public interface CarService {
	public void join(String name);
	public Car findCar(int CarId);
	public void moveAllCars();
	public List<Car> findWinningCars();
}
