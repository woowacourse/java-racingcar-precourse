/*
 * @(#) NameRuleException.java     1.0   2019/04/03
 *
 * Released under the MIT license
 */

package err;

/**
 * NameRuleException 클래스는 자동차이름 규칙 예외 처리 클래스다.
 *
 * @author 조남균
 * @version 1.00  2019년 04월 03일
 */
public class NameRuleException extends RuntimeException {
	public NameRuleException() {
	}

	public NameRuleException(String message) {
		super(message);
	}
}