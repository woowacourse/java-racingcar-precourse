package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void movePosition(){
        if((int)(Math.random()*10) >= 4){
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
