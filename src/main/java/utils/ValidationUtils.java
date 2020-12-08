package utils;

/**
 * 입력 값들의 유효성을 판단하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/05
 */
public class ValidationUtils {

    /* 5자리를 초과하거나 빈 문자가 있는지 검사하는 메소드 */
    public boolean isValidNames(String[] nameList) {
        for (int i = 0; i < nameList.length; i++) {
            String name = nameList[i];
            if ((name.length() > 5) || (name.indexOf(" ") > -1)
                || name.length() == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidNumberOfGame(int gameNumber) {
        if (gameNumber <= 0) {
            return false;
        }
        return true;
    }
}
