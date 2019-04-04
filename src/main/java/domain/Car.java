package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName(){ return this.name;}

    public int getCarPosition() {return this.position;}

    public int RandomMove(){
        /*
        * 랜덤 정수를 발생시키는 메소드
        * */
        Random r = new Random();
        int random = r.nextInt(10);
        return random;
    }

    public boolean DecideToMove(int random){
        /*
        * 랜덤값에 따라 이동을 결정하는 메소드
        * */
        if(random>=4){
            return true;
        }
        return false;
    }

    public void CalculateLocation(int random){
        /*
        * 전진/정지에 따라 차량의 위치를 변경하는 메소드
        * */
        if(!DecideToMove(random)){
            this.position++;
        }
        return;
    }
    // 추가 기능 구현
}
