package racingcar.domain.engine;

/**
 * 이 클래스는 지정 숫자 생성 클래스입니다.
 *
 * @author Byeonghwa Kim
 * @version 1.0
 */
public class FixedEngine implements Engine {

    private final int fixedDigit;

    public FixedEngine(int fixedDigit) {
        this.fixedDigit = fixedDigit;
    }

    @Override
    public int getDigit() {
        return this.fixedDigit;
    }
}
