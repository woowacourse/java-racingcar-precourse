package methodtest;

import inpututils.InputName;
import inpututils.inputRepetitions;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputName inputNameTest = new InputName(scanner);

        String[] testAnswer = inputNameTest.inputPlayerName();
        for (String answer : testAnswer) {
            System.out.println(answer);
        }

        inputRepetitions inputRepetTest = new inputRepetitions(scanner);

        System.out.println(inputRepetTest.inputanswer());
    }
}
