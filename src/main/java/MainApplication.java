import programIo.UserInput;

/**
 * 프로그램 시작을 위한 메인 클래스입니다.
 * @version : 1.0
 * @java-version : 1.8
 * @author : 김시영
 */
public class MainApplication {

    public static void main(String[] args) {
        String[] Users = UserInput.UsernameReturnArray();
        int playTimes = UserInput.HowManyTimesPlayReturn();

    }
}
