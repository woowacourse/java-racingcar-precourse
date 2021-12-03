package racingcar;

public class User implements IUser{
    @Override
    public String inputCarName() {
        return null;
    }

    @Override
    public int inputRepeatNumber() {
        return 0;
    }

    @Override
    public void informInputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void informInputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
