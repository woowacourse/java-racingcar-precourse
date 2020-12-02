package view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView(Scanner scanner){
        this.scanner = scanner;
    }

    public void println(String message){
        System.out.println(message);
    }

    public String inputNextLine(){
        return scanner.nextLine();
    }
}
