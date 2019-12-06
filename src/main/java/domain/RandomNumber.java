package domain;
import java.util.*;

public class RandomNumber {
    public static int randomNumberCreate() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber;
    }

    public static int checkNumber() {
        int answer = 0;

        if(randomNumberCreate() <= 3) {
            answer = 0;
        } else if(randomNumberCreate() >= 4) {
            answer = 1;
        }
        
        return answer;
    }
}