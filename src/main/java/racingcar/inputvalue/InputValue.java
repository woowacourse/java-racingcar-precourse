package racingcar.inputvalue;

public abstract class InputValue<T> {
    String inputString;

    public InputValue(String input) {
        this.inputString = input;
    }

    public T toRaceElement() {
        return convertTypeToRacingElement();
    }

    abstract T convertTypeToRacingElement();
}
