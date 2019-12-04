/**
 * class name : Car
 *
 * version : V 0.1
 *
 *
 * date : 2019.12.4
 *
 * copyright :
 *
 * description : 자동차의 움직임과 위치를 가지는 Car class
 */

package domain;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        position++;
    }

    public void printName() {
        System.out.println(this.name);
    }


}
