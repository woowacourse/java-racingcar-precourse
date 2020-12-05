package racingcar.domain;

import racingcar.domain.exception.NameLengthOutOfBoundsException;
import racingcar.domain.validator.NameValidator;

public final class Name {

    private final String name;

    public Name(final String name) {
        final int nameLength = name.length();

        if (nameLength < NameValidator.MINIMUM_NAME_LENGTH ||
                nameLength > NameValidator.MAXIMUM_NAME_LENGTH) {
            throw new NameLengthOutOfBoundsException(name, nameLength);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
