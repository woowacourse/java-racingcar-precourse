package inpututils;

import controlexception.UserInputNameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputRepetitions extends Input {
	private boolean CHECKEDERROR = false;

	public InputRepetitions(Scanner scanner) {
		super(scanner);
	}

	public int inputAnswer() {
		int repeat = 0;
		do {
			System.out.println("입력 횟수?");
			try {
				repeat =  scanner.nextInt();
				CHECKEDERROR = true;
			}catch(InputMismatchException i ){
				System.out.println("숫자만 입력이 가능합니다. 숫자로 다시 입력해주세요!");
				scanner = new Scanner(System.in);
			}
		}while(CHECKEDERROR == false);
		return repeat;
	}
}
