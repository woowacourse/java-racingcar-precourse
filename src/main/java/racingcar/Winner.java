package racingcar;

import java.util.Arrays;

public class Winner {
    private Car[] cars;
    StringBuilder stringBuilder; // 리스트로 변경할 것
    public Winner(Car[] cars){
        this.cars = cars;
        stringBuilder = new StringBuilder(); // 리스트로 변경할 것
    }


    public void grading(){
        int i = cars.length - 1;
        do{
            stringBuilder.append(cars[i].getName()).append(',');
            if(cars[i].getPosition() != cars[i-1].getPosition()) {
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                break;
            }
            i--;
        }while (i>0);
    }

    public String result(){
        Arrays.sort(cars);
        grading();
        String answer = stringBuilder.toString();
        return answer;
    }
}
