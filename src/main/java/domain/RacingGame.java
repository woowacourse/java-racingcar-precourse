package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private String input;
    private int trial;
    private ArrayList<Car> racer;
    RacingGame(){
        racer = new ArrayList<>();
    }

    private void parseInput(){
        String[] parsedName = input.split(",");
        for(String str:parsedName){
            racer.add(new Car(str));
        }
    }

    public void initGame(){
        System.out.println("Input the car names (name is split by ,)");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        System.out.println("Input the goal distance");
        trial = scan.nextInt();
        this.parseInput();
    }

    public void playGame(){
        System.out.println("Result");
        Random rand = new Random();
        for(int i = 0, randNum; i < trial; i++){
            for(Car car:racer){
                randNum = rand.nextInt(10);
                car.moveCar(randNum);
            }
            System.out.println("");
        }
    }
}
