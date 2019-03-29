package domain;

import java.util.Scanner;

public class Game {

    private String carNames;
    private String carName[];
    private Car car[];

    private int carNumber;
    private int raceNumber;

    public void run() {
        InputCarsName();
        splitCarNamesWithComma();
        InputRaceNum();

        for(int i = 0;i < raceNumber;i++){
            System.out.println();
            System.out.println("실행 결과");
            OneTimeRunGame();
        }
        printWinner();
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

    public void InputRaceNum(){
        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        raceNumber = scan.nextInt();
    }

    public void OneTimeRunGame(){
        for(int i = 0;i < carNumber;i++){
            car[i].OneTurn();
        }
    }

    public void printWinner(){
        int max = 0;
        int count = 0;
        for(int i = 0;i < carNumber;i++){
            if(max < car[i].getPosition()){
                max = car[i].getPosition();
            }
        }

        for(int i = 0;i < carNumber;i++){
            if(max == car[i].getPosition() && count == 0){
                System.out.print(car[i].getName());
                count++;
            }else if(max == car[i].getPosition()){
                System.out.print(", "+car[i].getName());
            }
        }
        System.out.println("가 최종 우승했습니다.");

    }


}
