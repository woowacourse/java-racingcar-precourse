package racingcar.dto;

public class CarDto {
	private final String name;
	private final int movingDistance;

	public CarDto(String name, int movingDistance) {
		this.name = name;
		this.movingDistance = movingDistance;
	}

	public String getName() {
		return name;
	}

	public int getMovingDistance() {
		return movingDistance;
	}
}
