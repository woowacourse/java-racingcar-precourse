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

    public boolean CKBoundary() {
        for (i=0;i<Names.length;i++) {
            if (Names[i].length() == 0) {
                System.out.println("Error Input.");
                return true;
            }
        }
        for (i=0;i<Names.length;i++) {
            if (Names[i].length() > 5) {
                System.out.println("Error Input.");
                return true;
            }
        }
        return false;
    }
    public void setCar(){
        cars = new Car[Names.length];
        for(i=0; i<cars.length; i++){
            cars[i] = new Car(Names[i]);
        }
    }

}
