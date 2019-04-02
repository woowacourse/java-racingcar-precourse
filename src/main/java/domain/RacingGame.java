package domain;

import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args){
        String[] CarName = InputCarNames();

    }

    public static String[] InputCarNames(){
        Scanner sc = new Scanner(System.in);
        String[] InputCar;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요: ");
            String Input = sc.nextLine();
            InputCar=Input.split(",");
        }while(!CheckCarNameLength(InputCar));
        return InputCar;
    }

    public static boolean CheckCarNameLength(String[] InputCarName){
        for(int i=0; i<InputCarName.length; i++){
            if(InputCarName[i].length()>5){
                System.out.println("자동차 이름을 5자 이하로 다시 입력해 주세요");
                return false;
            }
        }
        return true;
    }

}



