package racingcar;

public class RacingGame {

    private Player player;
    private Computer computer;

    public RacingGame(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void start() {

        String[] carList = getCarList();

        if (!computer.checkCarList(carList)) {
            System.out.println("[ERROR] 비정상적인 자동차 이름 입력");
            return;
        }

        String stringTryCount = getTryCount();

        if(!computer.isDigit(stringTryCount)){
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return;
        }

        int tryCount = Integer.parseInt(stringTryCount);

    }

    private String getTryCount() {
        String inputString = player.getInput();

        return inputString;
    }

    private String[] getCarList() {
        String inputString = player.getInput();
        String[] carList = computer.parseCarList(inputString);

        return carList;
    }

}
