package model.car.vo;

import java.util.Objects;

public class CarName {
    private final String value;

    public CarName(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 5 글자를 초과할 수 없습니다.");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
