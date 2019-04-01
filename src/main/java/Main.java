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
    
    /** 게임의 1개 라운드를 진행 */
    private static void playOneRound(List<Car> carList) {
        for (Car car : carList) {
            Manager.randomForward(car);
            System.out.println(car.getStatus());
        }
    }
    
    /** main 진입점 */
    public static void main(String[] args) {
        List<Car> carList = makeCarList();
        int tryCount = Manager.getTryCount();
        System.out.println("\n실행 결과 :");
        
        for (int i = 0; i < tryCount; i++) {
            playOneRound(carList);
            System.out.println(); // 구분용 빈 줄 출력
        }
    }
}
