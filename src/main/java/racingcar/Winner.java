package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class Winner {
    private Car[] cars;
    ArrayList<String> result;

    public Winner(Car[] cars){
        this.cars = cars;
        result = new ArrayList<>();
    }


    public void grading(){
        int i = cars.length - 1;
        do{
            result.add(cars[i].getName());
            if(cars[i].getPosition() != cars[i-1].getPosition()) {
                break;
            }
            i--;
        }while (i>0);
    }

    public String result(){
        Arrays.sort(cars);
        grading();
        String answer = arrayToString();
        return "최종 우승자 : " + answer;
    }

    public String arrayToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String name : result) {
            stringBuilder.append(name).append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
