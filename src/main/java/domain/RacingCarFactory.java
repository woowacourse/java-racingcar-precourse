package domain;

import domain.errors.InvalidInputException;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory implements RaceableFactory {

    private Validator validator;

    public RacingCarFactory(Validator validator) {
        this.validator = validator;
    }

    public List<Raceable> create(String[] names) {
        if (!validator.validateNames(names)) {
            throw new InvalidParameterException("자동차 이름이 옳바르지 않습니다.");
        }

        List<Raceable> raceables = new ArrayList<>();
        for (String name : names) {
            raceables.add(new RacingCar(name));
        }

        return raceables;
    }

}
