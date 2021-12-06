package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Cars {
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars of(List<String> names){
		validateSize(names);
		validateDuplication(names);
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			Car car = new Car(name);
			cars.add(car);
		}
		return new Cars(cars);
	}

	public void moveAll(){
		for (Car car : cars) {
			car.move();
		}
	}

	public String getFinalWinnerName(){
		int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.joining(", "));
	}

	private int getMaxPosition() {
		return cars.stream()
			.map(Car::getPosition)
			.max(Integer::compare)
			.orElse(-1);
	}

	private static void validateSize(List<String> names){
		if(names==null||names.isEmpty()){
			throw new IllegalArgumentException("[ERROR] 자동차의 이름을 입력해주세요.");
		}
	}

	private static void validateDuplication(List<String> names){
		Set<String> carSet = new HashSet<>(names);
		if(carSet.size()!=names.size()){
			throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복될 수 없습니다.");
		}
	}

	@Override
	public String toString() {
		return cars.stream()
			.map(Car::toString)
			.collect(Collectors.joining("\n"));
	}
}
