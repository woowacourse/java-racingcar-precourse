import util.MakeCar;
import util.Race;
import util.WinnigCar;
public class Main {
    /**
     * 게임 진행 메인 함수
     * @param args
     */
    public static void main(String[] args) {
        MakeCar.makingCar();
        Race.startGame();
        WinnigCar.getWinner();
    }
}