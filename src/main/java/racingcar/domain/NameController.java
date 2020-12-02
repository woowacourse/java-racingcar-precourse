package racingcar.domain;

public class NameController {
    private final static int MAX_LEN_OF_NAME = 5;

    private NameController() {

    }

    public String[] splitNamebyComma(String name) {
        String[] names = name.split(",");
        return names;
    }

    public boolean checkLengthOfName(String name) {
        if (name.length() <= MAX_LEN_OF_NAME) {
            return true;
        }
        return false;
    }
}
