package domain;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class Validator {

    public List<String> splitName(String name) {
        List<String> carNames = new LinkedList<>();

        Collections.addAll(carNames, name.split(","));

        return carNames;
    }

    public boolean isNotNull(List<String> carName) {
        return !(carName.isEmpty());
    }

    public boolean isNotExcess(List<String> carName) {
        return carName.stream().allMatch(name -> name.length() < 6);
    }

    public boolean isNotBelowZero(List<String> carName) {
        return carName.stream().allMatch(name -> name.length() > 0);
    }

    public boolean isNotBelowZero(int number) {
        return number > 0;
    }
}
