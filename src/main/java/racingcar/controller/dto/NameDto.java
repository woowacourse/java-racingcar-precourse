package racingcar.controller.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameDto {

    private List<String> names;

    private NameDto() {
    }

    public List<String> getNames() {
        return names;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private static final String DELIMITER = ",";

        private final NameDto dto;

        public Builder() {
            this.dto = new NameDto();
        }

        public Builder names(String names) {
            this.dto.names = parse(names);
            return this;
        }

        public NameDto build() {
            return this.dto;
        }

        private List<String> parse(String names) {
            return Arrays.stream(names.split(DELIMITER))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
    }
}
