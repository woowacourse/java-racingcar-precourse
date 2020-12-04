package inpututils;

import java.util.Scanner;

public abstract class Input {
	protected Scanner scanner;
	Input(Scanner scanner){
		this.scanner = scanner;
	}
	abstract Scanner getScanner();
}