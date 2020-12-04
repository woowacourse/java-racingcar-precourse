package methodtest;

import inpututils.InputName;
import inpututils.InputRepetitions;
import racingcar.GameCycle;

import java.util.Scanner;

public class GameRoutineTest {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		GameCycle gameTest = new GameCycle(new InputName(scanner).inputAnswer(), new InputRepetitions(scanner).inputAnswer());
	}
}
