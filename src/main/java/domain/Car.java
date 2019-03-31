package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    void showName(){
        System.out.println("Car의 이름 :" + name);
    }

    void showPosition(){
        System.out.println(name +"의 현재 위치 :" + position);
    }

    void forwardCar(){
        position++;
    }

    void showStatus(){
        System.out.print(name + ": ");
        for(int i=0; i<position;i ++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
