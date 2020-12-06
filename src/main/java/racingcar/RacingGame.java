package racingcar;

public class RacingGame {

    private Player player;
    private Computer computer;
    private Car[] cars;

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

        if (!computer.isDigit(stringTryCount)) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return;
        }

        cars = createCarInstance(carList);

        int tryCount = Integer.parseInt(stringTryCount);

        playRace(tryCount);
    }


    private Car[] createCarInstance(String[] carList) {
        Car[] cars = new Car[carList.length];

        for (int i = 0; i < carList.length; i++) {
            cars[i] = new Car(carList[i]);
        }

        return cars;
    }

    private void playRace(int tryCount) {

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++) {
            computer.moveCars(cars);
            computer.printCurrentCarsPosition(cars);
        }

        computer.printWinnerList(cars);
    }

    private String[] getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = player.getInput();
        String[] carList = computer.parseCarList(inputString);

        return carList;
    }

    private String getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        return player.getInput();
    }

}
