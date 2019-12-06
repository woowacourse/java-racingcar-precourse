package domain;

import java.util.*;

import domain.*;

public class MakeCar {
    public Car[] makingCar() {
        boolean check = false;
        String carString = "";
        Car[] car;
        Scanner sc = new Scanner(System.in);

        while(true) {
            check = false;
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            carString = sc.nextLine();

            /*(,)구분자로 문자열 파싱*/
            String[] carList = carString.split(",");

            car = new Car[carList.length];

            /*예외 처리*/
            for(int i=0;i<carList.length;i++){
                if(carList[i].length()<1||carList[i].length()>5){
                    check = true;
                    System.out.println("car이름은 1~5글자 입니다. 재입력!!!");
                }
            }

            /*자동차 개수만큼 동적배열 선언*/
            for (int i = 0; i < carList.length; i++) {
                car[i] = new Car(carList[i]);
            }

            /*예외처리 없으면 무한루프 탈출*/
            if(!check){
                break;
            }
        }
        return car;
    }
}
