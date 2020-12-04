package racingcar;

public class Validator {
    public static boolean isValidName(String names) {
        if(names.contains(" ")) return false;
        String[] splitNames = names.split(",");

        if(splitNames.length < 2) return false;
        for (String name : splitNames) {
            if (!Validator.isLengthValid(name)) return false;
        }
        return true;
    }

    private static boolean isLengthValid(String name){
        return name.length() > 0 && name.length() <= 5;
    }
}
