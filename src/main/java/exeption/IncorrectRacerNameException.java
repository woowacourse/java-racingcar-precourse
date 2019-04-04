package exeption;

import domain.Car;

/**
 * @author delf
 */
public class IncorrectRacerNameException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return String.format("이름이 너무 깁니다. (%d자 이하)", Car.MAX_LENGTH_RACER_NAME);
    }
}
