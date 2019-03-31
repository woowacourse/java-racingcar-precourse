package domain;

public class RacingGame {
    public static void main(String[] args){
        InputCar input = new InputCar();

        infoName();
        input.scanCar();
        input.setCar();
        infoPosition();
        input.setPosition();
    }

    static void infoName(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분합니다.");
    }
    static void infoPosition(){
        System.out.println("시도할 횟수는 몇회인가요?");
    }
}
