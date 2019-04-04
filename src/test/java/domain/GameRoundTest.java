package domain;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class GameRoundTest {
	private GameRound testGameRound;
	private List<Car> testCars;

	{
		testCars = new ArrayList<>();
		testCars.add(new Car("apple"));
		testCars.add(new Car("bad"));
		testCars.add(new Car("cloud"));
	}

	public GameRoundTest() {
		this.testGameRound = new GameRound(testCars);
	}

	@Test
	public void printGameRounds() {
		testGameRound.proceed();
		testGameRound.proceed();
		testGameRound.printOneRound();
	}
}