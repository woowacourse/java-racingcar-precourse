package domain;

import java.util.Scanner;
import java.util.ArrayList;

public class RacingGame {
    private String input;
    private int goal;
    private ArrayList<Car> racer;
    RacingGame(){
        racer = new ArrayList<>();
    }
    public void initGame(){
        System.out.println("Input the car names (name is split by ,)");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        System.out.println("Input the goal distance");
        goal = scan.nextInt();
    }
}
