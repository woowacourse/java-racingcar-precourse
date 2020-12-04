package inpututils;

import java.util.Scanner;

public class InputRepetitions extends Input{
	private Scanner scanner;

	InputRepetitions(Scanner scanner){
		super(scanner);
	}

	public int inputAnswer() {
		return scanner.nextInt();
	}
}
