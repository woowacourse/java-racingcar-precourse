package domain;

import java.util.Vector;

public class Manager {
    private Vector<String> carList;
    private User user;
    private int tryCount;

    public Manager(){
        user = new User();
    }

    public void startGame(){
        while(firstQuery() == false);
        while(secondQuery() == false);
    }

    public boolean secondQuery(){
        System.out.println("시도할 회수는 몇회인가요?");
        String ret = user.inputTryCount();
        try{
            Integer.parseInt(ret);
        }catch(NumberFormatException e){
            System.out.println(InputError.NUMBER_FORMAT_ERROR);
            return false;
        }
        tryCount = Integer.parseInt(ret);
        return true;
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
