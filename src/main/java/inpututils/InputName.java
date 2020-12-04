package inpututils;

import java.util.Scanner;

public class InputName extends Input{
	public InputName(Scanner scanner){
		super(scanner);
	}

	@Override
	Scanner getScanner() {
		return super.scanner;
	}

	public String[] inputAnswer() {
		return splitRest(getScanner().next());
	}

	public String[] splitRest(String answer) {
		return answer.split(",");
	}
}
