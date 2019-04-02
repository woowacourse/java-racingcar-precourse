package domain;

/*
 * Class Car
 *
 *
 *
 * 2019.04.02
 *
 * @author jins408
 *
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        int num = (int) (Math.random() * 10); // 0~9
        if (num >= 4)
            position++;
    }

    public void print() {
        System.out.print(name +" : " );
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
