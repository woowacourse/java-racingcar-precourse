package util;
import java.util.ArrayList;
import domain.Car;
public class MakeCar {

    public static ArrayList<Car> carArray = new ArrayList<>();

    /**
     * 자동차 객체 어레이 생성 & 입력
     */
    public static void makingCar(){
        String [] nameArray = NameInput.getCarName();
        for (String name : nameArray) {
            carArray.add(new Car(name));
        }
    }

}
