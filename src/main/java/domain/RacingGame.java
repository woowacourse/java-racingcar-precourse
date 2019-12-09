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

    private int getMax(){
        int max = 0;
        int temp;
        for(Car car:racer){
            temp = car.getPosition();
            if(max < car.getPosition()){
                max = temp;
            }
        }
        return max;
    }

    public void initGame(){
        System.out.println("Input the car names (name is split by ,)");
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        System.out.println("Input the turn value");
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

    public void printResult(){
        int highScore = this.getMax();
        StringBuilder output = new StringBuilder();
        for(Car car:racer){
            if(car.getPosition() == highScore){
                output.append(car.getName()+",");
            }
        }
        output.replace(output.length()-1,output.length(),": the final WINNER!");
        System.out.println(output);
    }
}
