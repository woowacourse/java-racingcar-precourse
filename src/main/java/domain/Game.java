package domain;

import java.util.Scanner;

public class Game {

    String carNames;
    String carName[];
    Car car[];

    int carNumber;

    public void run() {
        InputCarsName();
        splitCarNamesWithComma();

    }

    public void InputCarsName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = scan.nextLine();
    }

    public void splitCarNamesWithComma(){
        carName = carNames.split(",");
        carNumber = carName.length;
        initCarObject();
    }

    public void initCarObject(){
        car = new Car[carNumber];
        for(int i = 0;i < carNumber;i++){
            car[i] = new Car(carName[i]);
        }
    }



}
