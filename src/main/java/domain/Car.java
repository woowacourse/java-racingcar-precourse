package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    int getPosition(){
        return position;
    }

    String getName(){
        return name;
    }

    void forwardCar(){
        position+=1;
    }

    void showStatus(){
        System.out.print(name + ": ");
        for(int i=0; i<position;i ++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
