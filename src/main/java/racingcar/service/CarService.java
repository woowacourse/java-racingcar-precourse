package racingcar.service;

import racingcar.Car;

public interface CarService {
	public void join(String name);
	public Car findCar(int CarId);
	public void moveAllCars();
}
