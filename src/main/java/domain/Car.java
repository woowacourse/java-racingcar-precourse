package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition(){ return position; }

    public String getName(){ return name;}

    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt();
    }

    public void moveForward(){
        int randomNumber = generateRandomNumber();
        if( randomNumber < 4) position++;
    }

    public void printPosition(){
        System.out.print(name+":");
        for(int i =0 ; i< position; i++){
            System.out.print("-");
        }
        System.out.println("");
    }

}
