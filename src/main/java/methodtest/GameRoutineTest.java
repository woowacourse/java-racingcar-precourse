package methodtest;

import inpututils.InputName;
import inpututils.InputRepetitions;
import racingcar.GameManagement;

import java.util.Scanner;

public class GameRoutineTest {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		GameManagement gameTest = new GameManagement(new InputName(scanner).inputName(), new InputRepetitions(scanner).inputAnswer());
	}
}
