package racingcar;
public class Application {

    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
        Game game = new Game();
        game.start();
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }


}
