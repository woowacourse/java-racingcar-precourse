package racingcar.domains.validate;

public interface Validator<T> {
    public void isValid(T name);
}
