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
    public void Gamestart() {
        System.out.println("Execution Results");
        System.out.println(num);
        System.out.println(cars.length);
        for(i=0;i<num;i++) {
            for(j=0;j<cars.length;j++) {
                cars[j].running();
                prints(cars[j]);
            }
            System.out.println(i);
        }
    }
    public void prints(Car car){
        System.out.print(car.getName() + ":");
        for(k=0;k<car.getPosition();k++){
            System.out.print("-");
        }
        System.out.println();
    }
    public void EndGame(){
        int max=0,cnt=0;
        for(i=0;i<cars.length;i++){
            if(cars[i].getPosition()>max)
                max = cars[i].getPosition();
        }
        for(i=0;i<cars.length;i++){
            if(cars[i].getPosition()==max)
                System.out.print(cars[i].getName() + " ");
        }
        System.out.print("Won the Final");
    }
}
