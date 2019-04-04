package domain;
import java.util.Random;
import java.util.Scanner;
public class Car {
    public static Scanner sc = new Scanner(System.in);
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void RandomMove(){
        Random random = new Random();
        int randomnew = random.nextInt(10);
        if(randomnew > 3){
            this.position++;
        }

    }

    public void FindWinner(){

    }

    public void PrintUser(){
        

    }

    /*
        - 0에서 9까지 랜덤으로 값을 지정한다
        - 4이상일 경우 전진
        - 3이하일 경우 그대로 머문다.
    **printMove
        - 이동 거리를 "-"로 출력한다.
    **FindWinner
        - 우승자를 찾는다
    **PrintUser
        - 자동차 이름을 출력한다.
    // 추가 기능 구현*/
}
