package domain;

import java.util.Vector;

public class Manager {
    private Vector<String> carList;
    private User user;

    public Manager(){
        user = new User();
    }

    public void startGame(){
        while(firstQuery() == false);
    }

    public boolean firstQuery(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        carList = user.inputCarName();
        return checkCarName();
    }

    public boolean checkCarName(){
        return true;
    }
}
