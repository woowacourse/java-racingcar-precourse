package domain;
import java.util.*;

public class Game {
    public static void gameStart(String carName, int count) {
        ArrayList<Car> carList = inputSlice(carName); //입력받은 차 이름을 carList에 나누어 저장

        for(int i = 0; i < count; i++) {
            racingSimulation(carList, count);         //count만큼 자동차 전진 시뮬레이션을 진행
        }

        winnerCheck(carList);
    }

    public static ArrayList<Car> inputSlice(String carName) { //입력받은 차 이름을 ArrayList로 나누어 저장
        ArrayList<Car> carList = new ArrayList<Car>();
        String[] carNames = carName.split(",");

        for(int i = 0; i < carNames.length; i++) {
            Car temp = new Car(carNames[i]);
            carList.add(temp);
        }
        return carList;
    }

    public static void racingSimulation(ArrayList<Car> carList, int count) {
        for(int j = 0; j < carList.size(); j++) {
            Car.addPosition(carList.get(j), RandomNumber.checkNumber());    //순서대로 랜덤 숫자에 의해 이동
        }

        System.out.println();
        
        for(int j = 0; j < carList.size(); j++) {
            Car.positionState(carList.get(j));                              //차의 위치를 출력
        }

        System.out.println();
    }

    public static void winnerCheck(ArrayList<Car> carList) {
        ArrayList<String> winner = new ArrayList<String>();
        int winnerPosition = 0;

        for(int i = 0; i < carList.size(); i++) {
            if(Car.carPosition(carList.get(i)) > winnerPosition) {          //차들 중 position이 가장 높은 것의 position과 name을 저장
                winner = new ArrayList<String>();
                winner.add(Car.carName(carList.get(i)));
                winnerPosition = Car.carPosition(carList.get(i));
            }
            else if(Car.carPosition(carList.get(i)) == winnerPosition) {    //position이 동일할 경우, name을 추가로 저장
                winner.add(Car.carName(carList.get(i)));
            }
        }
        winnerNotice(winner);
    }

    public static void winnerNotice(ArrayList<String> winner) {
        if(winner.size() == 1) {        //우승자가 한명일 경우
            System.out.printf("%s가 우승했습니다.", winner.get(winner.size() - 1));
        }
        else if(winner.size() > 1) {    //우승자가 여러명일 경우
            for(int i = 0; i < winner.size() - 1; i++) {
                System.out.printf("%s,",winner.get(i));
            }
            System.out.printf("%s가 우승했습니다.", winner.get(winner.size() - 1));
        }
    }
}