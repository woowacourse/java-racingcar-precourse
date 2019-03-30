
package domain;
import java.util.Scanner;
/**
 * Car 클래스는 자동차에 관련된 모든 상태를 나타내는 클래스 입니다.
 *
 * @version 2019년 3월 30일
 * @author 이중혁
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }


    public static String getCarName(){

        Scanner inputCarName = new Scanner(System.in);
        Car carName = new Car(inputCarName.nextLine());

        return carName.name;
    }
}
