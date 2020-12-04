package methodtest;

import inpututils.InputName;
import inpututils.InputRepetitions;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		InputName inputNameTest = new InputName(scanner);

		String[] testAnswer = inputNameTest.inputAnswer();
		for(String answer : testAnswer){
			System.out.println(answer);
		}

		InputRepetitions inputRepetTest = new InputRepetitions(scanner);

		System.out.println(inputRepetTest.inputAnswer());
	}
}
