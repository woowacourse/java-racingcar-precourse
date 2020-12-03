package preprocess;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputPreProcess {

    private static final String NAME_REGEX = "^[ㄱ-ㅎ|ㅏ-ㅑ가-힣\\sa-zA-Z]*$";
    private static final String INPUT_REGEX = "^[ㄱ-ㅎ|ㅏ-ㅑ가-힣\\sa-zA-Z,]*$";
    private static final String SPLITTER = ",";

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private static final String NAME_ERROR = "[ERROR] 이름은 한글 또는 영어로만 되어야 한다.";
    private static final String LENGTH_ERROR = "[ERROR] 이름은 " + MIN_NAME_LENGTH +
            "글자 이상이거나 " + MAX_NAME_LENGTH + "글자 이하여만 합니다.";


    public InputPreProcess() {}

    public String[] getNames(String str) {

        String[] names = splitName(str);

        if (!checkName(names)) {
           return null;
        }
        else if (!checkLength(names)) {
            return null;
        }

        return names;
    }

    private boolean checkLength(String[] names) {

        if (!checkAllNameLength(names)) {
            System.out.println(LENGTH_ERROR);
            return false;
        }
        return true;
    }

    private boolean checkName(String[] names) {

        if (!checkAllNameValid(names)) {
            System.out.println(NAME_ERROR);
            return false;
        }
        return true;
    }

    private boolean checkInputValid(String str) {
        return Pattern.matches(INPUT_REGEX, str);
    }

    private boolean checkAllNameLength(String[] names) {

        for (String name : names) {
            if (!checkNameLength(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNameLength(String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() == MAX_NAME_LENGTH;
    }



    private String[] splitName(String str) {
        return str.split(SPLITTER);
    }

    private boolean checkAllNameValid(String[] names) {

        for (String name : names) {
            if (!checkNameValid(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNameValid(String name) {
        return Pattern.matches(NAME_REGEX, name);
    }
}
