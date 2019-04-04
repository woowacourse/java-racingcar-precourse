
public class Car {
    private final String name;  // Car class인스턴스의 name값
    private int position = 0;   // Car class인스턴스의 위치값

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return(name);
    }

    public int getPosition() {
        return(position);
    }

}
