package domain;
import java.util.*;

public class RandomNumber {
    public static int randomNumberCreate() {        //랜덤 숫자 생성
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber;
    }

    public static int checkNumber() {               //랜덤 숫자를 조건문에 따라 전진 할 지를 반환
        int answer = 0;

        if(randomNumberCreate() <= 3) {
            answer = 0;
        } else if(randomNumberCreate() >= 4) {
            answer = 1;
        }
        
        return answer;
    }
}