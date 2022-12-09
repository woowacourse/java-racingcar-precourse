package racingcar.controller.dto;

public class TrialDto {

    private int trial;

    private TrialDto() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getTrial() {
        return trial;
    }

    public static class Builder {

        private static final String ERROR_MESSAGE = "[ERROR] 시도 횟수는 양의 정수입니다.";

        private final TrialDto dto;

        public Builder() {
            this.dto = new TrialDto();
        }

        public Builder trial(String trial) {
            int parsedTrial = parse(trial);
            validate(parsedTrial);
            this.dto.trial = parsedTrial;
            return this;
        }

        public TrialDto build() {
            return this.dto;
        }

        private int parse(String trial) {
            try {
                return Integer.parseInt(trial);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }

        private void validate(int parsedTrial) {
            if (isNegative(parsedTrial)) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }

        private boolean isNegative(int parsedTrial) {
            return parsedTrial < 0;
        }
    }
}
