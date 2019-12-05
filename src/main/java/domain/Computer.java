package domain;

/**
 * @author 김시영
 * @since 2019-12-05
 * @apiNote 랜덤한 난수를 생성하기 위한 클래스입니다.
 */
public class Computer {
    private static final int RANGE_OF_NUMBER = 9;

    public static int makeRandomNumber() {
        return (int) (Math.random() * RANGE_OF_NUMBER);
    }

}
