package racingcar;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;
    public static List<Car> carList = new ArrayList<>();

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }



    // 추가 기능 구현
}
