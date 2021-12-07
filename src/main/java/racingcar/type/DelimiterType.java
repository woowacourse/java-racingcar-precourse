package racingcar.type;

public enum DelimiterType {
	CAR_NAME_DELIMITER(","),
	DISTANCE("-"),
	COLON(":");


	private final String delimiter;

	DelimiterType(String delimiter){
		this.delimiter = delimiter;
	}

	public String getDelimiter(){
		return delimiter;
	}
}
