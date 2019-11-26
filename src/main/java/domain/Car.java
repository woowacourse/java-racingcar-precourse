package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사용자 객체를 생성하기 위한 Car class입니다.
 * @author : 김시영
 * @version : 1.0
 * @java-version : 1.8
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static void HowManyMove(List<Car> userList) {
        for(int k =0; k<userList.size(); k++){
            if(makeRandomNumber()>=4)
                userList.get(k).position++;
            System.out.print(userList.get(k).toString()+" ");
        }
        System.out.println("");

    }

    private static int makeRandomNumber() {
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber;
    }

    public static String getWinner(List<Car> userList) {
        List<Integer> maxUser = new ArrayList<>();
        String result = "";
        for(int i=0; i<userList.size(); i++){
            maxUser.add(userList.get(i).position);
        }
        int maxNumber = Collections.max(maxUser);
        for(int i=0; i<userList.size(); i++)
            if(userList.get(i).position==maxNumber)
                result += userList.get(i).name+" ";
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<position; i++){
            result += "*";
        }
        return name +"--" + result ;
    }
}
