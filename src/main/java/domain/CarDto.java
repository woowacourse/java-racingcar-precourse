package domain;

public class CarDto {
	private String name;
	private int position;

	private CarDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static CarDto from(Car car) {
		Name name = car.getName();
		Position position = car.getPosition();
		return new CarDto(name.toString(), position.toInt());
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}
}
