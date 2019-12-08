package domain;

import java.util.Scanner;

public class InputScanner {

    private static Scanner scanner = new Scanner(System.in);

    String getCarName() {
        return scanner.nextLine();
    }

}
