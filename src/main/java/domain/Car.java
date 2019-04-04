package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /* 4이상일때는 움직이고 그 외에는 움직이지 않는다. */
    public void goForward() {
        int go = (int) (Math.random() * 9);

        if (go >= 4) {
            position += go;
        }

    }

    public int getPosition() {
        return position;
    }

    public String getCarsName() {
        return name;
    }

}
