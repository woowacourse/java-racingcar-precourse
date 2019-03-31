package domain;

import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args){
        InputCar input = new InputCar();
        ForwardCar forward = new ForwardCar();
        int stage = 0;

        infoName();
        input.scanCar();
        input.setCar();
        infoStage();
        stage = setStage();
        startGame(input,forward,stage);
    }

    static void infoName(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분합니다.");
    }
    static void infoStage(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    static int setStage(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    static void startGame(InputCar input, ForwardCar forward, int stage){

        for(int i=0; i<stage; i++) {
            for(int j=0; j<input.carNameList.length;j++) {
                forward.decideForward(input.carArr[j]);
                input.carArr[j].showStatus();
            }
            System.out.println("");
        }
    }
}
