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
    private static int playOneRound(List<Car> carList) {
        int max = 0;
        int position;
        
        for (Car car : carList) {
            Manager.randomForward(car);
            System.out.println(car.getStatus());
            position = car.getPosition();
            if (position > max) {
                max = position;
            }
        }
        
        return max;
    }
    
    /** 최종 우승자를 판정 */
    private static String getWinners(List<Car> carList, int maxPosition) {
        List<String> winnerList = new ArrayList<String>();
        
        for (Car car: carList) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }
        
        return String.join(", ", winnerList);
    }
    
    /** main 진입점 */
    public static void main(String[] args) {
        int maxPosition = 0;
        List<Car> carList = makeCarList();
        int tryCount = Manager.getTryCount();
        System.out.println("\n실행 결과 :");
        
        for (int i = 0; i < tryCount; i++) {
            maxPosition = playOneRound(carList);
            System.out.println(); // 구분용 빈 줄 출력
        }
        
        String winners = getWinners(carList, maxPosition);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
