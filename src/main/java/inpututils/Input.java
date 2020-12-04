package inpututils;

import java.util.Scanner;

public abstract class Input {
	private Scanner scanner = null;

	Input(Scanner scanner){
		this.scanner = scanner;
	}
}