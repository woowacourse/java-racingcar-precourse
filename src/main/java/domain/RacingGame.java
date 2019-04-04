package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RacingGame {

    private String carNames;
    private BufferedReader br;

    public RacingGame() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean setCarNames() {
        this.showMessage("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            String inputCarNames = br.readLine();
            if (isValidateCarNames(inputCarNames)) {
                this.carNames = inputCarNames;
                return true;
            }
            this.showMessage("유효하지 않은 입력, 이름은 5자 이하입니다.");
        } catch (Exception e) {
            this.showMessage("입력 오류 입니다.");
        }

        return false;
    }

    public boolean isValidateCarNames(String inputCarNames) {
        boolean isValidate = true;
        for (String carName : inputCarNames.split(",")) {
            if (carName.length() > 5) {
                isValidate = false;
                break;
            }
        }
        return isValidate;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }


}
