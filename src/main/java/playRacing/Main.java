package playRacing;

import domain.Car;

import java.util.Arrays;

public class Main {
    static Car[] cars;

    public static void main(String[] args) {

    }
  
    public static boolean isNameValid(String[] names){
        for(int i=0; i<names.length; i++){
            if(names[i].length()>5){
                return false;
            }
        }
        return true;
    }

    /**
     *  모든 자동차의 액션(멈춤/전진)을 실행시키는 함수
     */
    public static void startAction(){
        for(int i=0; i< cars.length; i++){
            cars[i].goOrStop();
        }
    }
    public static void printAllPostion(){
        StringBuilder allPosition = new StringBuilder();
        for(int i=0; i<cars.length; i++){
            allPosition.append(cars[i].printPosition()+"\n");
        }
        System.out.println(allPosition.toString());
    }

   
}
