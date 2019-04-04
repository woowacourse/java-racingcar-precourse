package domain;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public int random_value(){
        Random generator = new Random();
        return generator.nextInt(10);
    }
    public boolean gostop(){
        int num = random_value();
        if(num>=4) return true;
        return false;
    }
    public void move(){
        if(gostop())
            this.position++;
    }
    public void print_status(){
        System.out.print(this.name + " : ");
        for(int i=1; i<=position; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public int position(){
        return this.position;
    }
    public String name() {
        return this.name;
    }
}
