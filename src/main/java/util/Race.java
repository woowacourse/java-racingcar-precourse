package util;
import java.util.ArrayList;
import domain.Car;
public class Race {
    private int winnerNum;
    public static void startGame() {
        int gameTimes = TimesInput.getTimes();
        doRace(gameTimes, MakeCar.carArray);
    }

    private static void doRace(int times, ArrayList<Car> cars){
        for (int i = 0; i < times; i++){

        }
    }

    private void printProgress(){

    }

    private void printResult(){

    }

    /**
     * 0 ~ 9 사이 난수 출력
     * @return
     */
    private int randomNum(){
        // 랜덤 함수를 이용해 0 ~ 1 사이의 난수를 출력 후 정수화 하고 0 ~ 9 로 변환
        double randomNumber = Math.random();
        int intNumber = (int)Math.floor(randomNumber * Constants.UNDER_RANDOM_NUM);
        return intNumber;
    }
}
