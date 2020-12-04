package inpututils;

import java.util.Scanner;

public class InputName extends Input{
	private Scanner scanner;

	InputName(Scanner scanner){
		super(scanner);
	}

	public String[] inputAnswer() {
		return splitRest(scanner.next());
	}

	public String[] splitRest(String answer) {
		return answer.split(",");
	}
}
