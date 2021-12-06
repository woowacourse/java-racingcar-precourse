package racingcar;

import java.util.ArrayList;

public class PlayGame {
    Computer computer;
    User user;
    String[] cars;

    public void Play(){
        initSetting();
        CarName();
    }

    //초기 세팅 함수
    private void initSetting(){
        computer = new Computer();
        user = new User();
    }
    
    //자동차 이름 입력 함수
    private void CarName(){
        computer.MSGCarName();
        cars = user.InputCarName();
    }

}
