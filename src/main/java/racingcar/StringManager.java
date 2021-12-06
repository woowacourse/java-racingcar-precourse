package racingcar;

public class StringManager {
    static final String parser = ",";

    public StringManager() {
    }

    public String[] parseCarNamesInput(String carNamesInput) {
        String[] carNames = carNamesInput.split(parser);

        for (String s : carNames) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    public int toInt(String inputString) {
        int inputInt;

        try {
            inputInt = Integer.parseInt(inputString);
            return inputInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
