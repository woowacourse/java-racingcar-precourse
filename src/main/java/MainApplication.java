import domain.Car;
import programIo.UserInput;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그램 시작을 위한 메인 클래스입니다.
 * @version : 1.0
 * @java-version : 1.8
 * @author : 김시영
 */
public class MainApplication {

    public static void main(String[] args) {
        String[] users = UserInput.UsernameReturnArray();
        int playTimes = UserInput.HowManyTimesPlayReturn();
        List<Car> userList = new ArrayList<>();
        for(int i=0; i<users.length; i++){
            userList.add(new Car(users[i]));
        }
        for(int k=0; k<playTimes; k++){
            Car.HowManyMove(userList);
        }
        System.out.println("최종 우승자는 : " + Car.getWinner(userList)+" 입니다 ");
    }
}
