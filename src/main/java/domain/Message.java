package domain;

import java.util.HashMap;

public class Message {
    public static HashMap<String, String> gameInputMessage = new HashMap<String, String>() {
        {
            put("INPUT_CARNAME", "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            put("INPUT_GAMECOUNT","시도할 횟수는 몇회인가요?");
        }
    };
    public static HashMap<String, String> gameOutputMessage = new HashMap<String, String>() {
        {
            put("OUTPUT_GAMERESULT"," 실행결과 ");
            put("OUTPUT_GAMEWINNER"," 가 최종 우승했습니다.");
        }
    };
    public static HashMap<String, String> errorMessage = new HashMap<String, String>() {
        {
            put("ERROR_NAMELENGTH"," 자동차 이름이 5글자가 초과되어 제외합니다.");
            put("ERROR_NAMEEMPTY","자동차 이름을 1대 이상 입력하세요.");
            put("ERROR_GAMECOUNTLIMIT"," 시도할 횟수를 0이상으로 입력해주세요.");
            put("ERROR_GAMECOUNTTYPE"," 시도할 횟수를 숫자로 입력하세요.");
        }
    };
}
