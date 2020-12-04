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
		System.out.println("시도할 회수는 몇회인가요?");
		return getScanner().nextInt();
	}
}
