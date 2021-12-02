package racingcar.dto;

public class CarDTO {
	private String name;
	private int movingDistance;

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
