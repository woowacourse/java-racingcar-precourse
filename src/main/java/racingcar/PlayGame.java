package racingcar;

import java.util.ArrayList;

public class PlayGame {
    Computer computer;
    User user;
    String[] carString;
    Integer playNum;
    ArrayList <Car> cars = new ArrayList<>();

    public void Play(){
        initSetting();
        CarName();
        PlayNum();
    }

    //초기 세팅 함수
    private void initSetting(){
        computer = new Computer();
        user = new User();
    }
    
    //자동차 이름 입력 함수
    private void CarName(){
        computer.MSGCarName();
        carString = user.InputCarName();
        CarList();
    }

    // stringq 배열을 Car 객체 ArrayList로 변경
    private void CarList(){
        for(String car : carString){
            Car c = new Car(car);
            cars.add(c);
        }
    }


    // 시도 횟수 입력
    private void PlayNum(){
        computer.MSGPlayNum();
        playNum = user.InputPlayNum();
    }
}
