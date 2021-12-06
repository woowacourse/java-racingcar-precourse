package racingcar;

import java.util.ArrayList;

public class PlayGame {
    Computer computer;
    User user;
    String[] cars;
    Integer playNum;

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
        cars = user.InputCarName();
    }

    // 시도 횟수 입력
    private void PlayNum(){
        computer.MSGPlayNum();
        playNum = user.InputPlayNum();
    }
}
