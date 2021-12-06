package racingcar;

public class Output {
	public static void movementState(CarList cars){
		cars.getMovementState()
			.forEach((state) -> System.out.println(state + "\n"));
	}

	public static void winners(CarList cars){
		System.out.println("최종 우승자 : "
			+ String.join(", ", cars.getWinners()));
	}
}
