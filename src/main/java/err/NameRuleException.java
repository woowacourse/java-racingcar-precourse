package err;

public class NameRuleException extends RuntimeException {
	public NameRuleException() {}
	public NameRuleException(String message) {
		super(message);
	}
}
