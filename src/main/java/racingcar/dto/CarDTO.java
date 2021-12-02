package racingcar.dto;

public class CarDTO {
	private final String name;
	private final int movingDistance;

	public CarDTO(String name, int movingDistance) {
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
