package domain;

import java.util.Vector;

public class Manager {
    private Vector<String> calList;

    public void startGame(){
        firstQuery();
    }

    public void firstQuery(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        //carList = User.inputCarName();
    }
}
