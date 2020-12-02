package exception;

public class CarNameOverFiveException extends CarRacingGameException {

    public CarNameOverFiveException() {
        System.out.println(getErrorHeader() + "자동차의 이름은 5자 이하여야 한다.");
    }
}
