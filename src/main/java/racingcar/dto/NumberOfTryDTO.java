package racingcar.dto;

public class NumberOfTryDTO {
    private final int numberOfTry;
    
    public NumberOfTryDTO(final String numberOfTry) {
        this.numberOfTry = Integer.parseInt(numberOfTry);
    }
}
