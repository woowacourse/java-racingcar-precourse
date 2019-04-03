package util;
import java.util.ArrayList;
import domain.Car;
public class Race {
    private int winnerNum;
    private static final String RESULT_PRINT = "실행 결과";

    /**
     * 게임 전체 시작
     */
    public static void startGame() {
        int times = TimesInput.getTimes();
        System.out.println("\n\n" + RESULT_PRINT + "\n");
        doRace(times);
    }

    /**
     * 입력된 횟수 만큼 레이스 시작
     */
    private static void doRace(int times){
        for (int i = 0; i < times; i++){
            eachRound(MakeCar.carArray);
            printProgress(MakeCar.carArray);
        }
    }

    /**
     * 전진 혹은 정지를 결정하는 하나의 라운드
     * @param cars 각각의 차
     */
    private static void eachRound(ArrayList<Car> cars){
        for(int i = 0; i<cars.size(); i++){
            if(stopOrForward()){
                // 차 객체 내부 메소드로 포지션 값 변경
                cars.get(i).moveForward();
            }
        }
    }

    /**
     * 난수가 4 이상일 시 true를 출력하는 함수
     */
    private static boolean stopOrForward(){
        if(randomNum() >= Constants.IF_MORE_FORWARD){
            return true;
        }
        return false;
    }

    /**
     * 각 라운드의 진행결과를 출력하는 함수
     */
    private static void printProgress(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).printProgress();
        }
        System.out.print("\n");
    }

    private void printResult(){

    }

    /**
     * 0 ~ 9 사이 난수 출력
     * @return 난수
     */
    private static int randomNum(){
        // 랜덤 함수를 이용해 0 ~ 1 사이의 난수를 출력 후 정수화 하고 0 ~ 9 로 변환
        double randomNumber = Math.random();
        int intNumber = (int)Math.floor(randomNumber * Constants.UNDER_RANDOM_NUM);
        return intNumber;
    }
}
