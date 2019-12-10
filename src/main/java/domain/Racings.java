package domain;
import java.util.Scanner;

public class Racings {

    Scanner scanner = new Scanner(System.in);
    String[] Names;
    Car[] cars;
    int i,num,j,k;

    public void game(){
        String Car;
        System.out.println("Input Racing Cars Name");
        Car = scanner.nextLine();
        Names = Car.split(",");
        if(CKBoundary()) return;
        setCar();
        System.out.println("How many times game implements?");
        num = scanner.nextInt();
        Gamestart();
        EndGame();
    }
}
