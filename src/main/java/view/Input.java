package view;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public Input() {
    }

    public String inputCars(){
        return scanner.nextLine();
    }
}
