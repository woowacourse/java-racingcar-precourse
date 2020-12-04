package inpututils;

import java.util.Scanner;

public class InputRepetitions extends Input{
	public InputRepetitions(Scanner scanner){
		super(scanner);
	}

	@Override
	Scanner getScanner() {
		return super.scanner;
	}

	public int inputAnswer() {
		return getScanner().nextInt();
	}
}
