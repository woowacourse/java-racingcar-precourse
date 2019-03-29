package domain;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        String[] carNames;
        int cnt;
        boolean flag = false;

        while (!flag) {
            carNames = ui.inputCarNames();
            flag = ui.checkValidationCarNames(carNames);
        }

        flag = false;
        while (!flag) {
            cnt = ui.inputCnt();
            flag = ui.checkValidationCnt(cnt);
        }
    }
}
