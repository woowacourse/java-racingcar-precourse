import java.util.*;
import domain.*;

public class Main {
    /** 경주에 참여할 자동차들을 생성 */
    private static List<Car> makeCarList() {
        List<Car> newList = new ArrayList<Car>();
        String[] names = Manager.getCarNames();
        
        for (String name: names) {
            newList.add(new Car(name));
        }
        
        return newList;
    }
    
    /** main 진입점 */
    public static void main(String[] args) {
        List<Car> carList = makeCarList();
    }
}
