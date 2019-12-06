package domain;

import java.util.Scanner;

public class ConsoleMain {
    private String[] carName;

    public static void main(String[] args){

    }

    private void inputCarName() {
        Scanner sc = new Scanner(System.in);
        String carName_Line;

        System.out.println("경주할 자동차 이름을 입력하세요."
                                +"(이름은 쉼표(,) 기준으로 구분)");
        carName_Line = sc.nextLine();
        carName = carName_Line.split(",");

        for(int i = 0; i < carName.length; i++){
            if(carName[i].length() > 5){
                inputCarName();
            }
        }
    }
}
