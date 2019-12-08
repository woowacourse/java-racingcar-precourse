package domain;

import java.util.Scanner;

public class InputScanner {

    private static Scanner scanner = new Scanner(System.in);

    public String getCarName() {
        return scanner.nextLine();
    }

    public int howManyPlay() {
        return scanner.nextInt();
    }

}
