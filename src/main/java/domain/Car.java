/*
 * Car.java
 * 20190403
 * ver 1.0.0
 * leejk118
 */

package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }

    private int generateRandomNum(){
        return (int)(Math.random() * 9);
    }
    public void decideGoStop(){
        if (this.generateRandomNum() >= 4){
            position++;
        }
    }
}
