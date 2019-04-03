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
        for(int i=0; i<carList.size(); i++) {
            if(carList.get(i).length() > 5) {
                System.out.println(InputError.LENGTH_ERROR);
                return false;
            }
        }
        return true;
    }
}
