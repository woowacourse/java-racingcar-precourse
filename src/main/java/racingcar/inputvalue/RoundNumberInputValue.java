package racingcar.inputvalue;

public class RoundNumberInputValue extends InputValue<Integer> {
    public RoundNumberInputValue(String input) {
        super(input);
    }

    @Override
    Integer convertTypeToRacingElement() {
        validate();
        return Integer.parseInt(inputString);
    }

    private void validate() {
        for (Character character : inputString.toCharArray()) {
            if(!Character.isDigit(character)) {
                throw new IllegalArgumentException();
            }
        }
    }


}
