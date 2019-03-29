package domain;

public class Car {
    private final String name;
    private int position = 0;

    private int randomNum;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void makeRandomNumber(){
        randomNum = (int)(Math.random()*10);
    }

    public void checkRandomNumberAndChangePosition(){
        if(randomNum >= 4){
            position++;
        }
    }
}
