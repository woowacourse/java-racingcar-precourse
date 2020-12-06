package racingcar;

public class RacingGame {

    private final Player player;
    private final Computer computer;
    private Car[] cars;

    public RacingGame(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void start() {

        String[] carList = getCarList();
        int tryCount = getTryCount();
        createCarInstance(carList);

        playRace(tryCount);
    }


    private void createCarInstance(String[] carList) {
        cars = new Car[carList.length];

        for (int i = 0; i < carList.length; i++) {
            cars[i] = new Car(carList[i]);
        }
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
        String[] carList;

        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String inputString = player.getInput();
                carList = computer.parseCarList(inputString);
                computer.checkCarList(carList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 비정상적인 자동차 이름 입력");
            }
        }
        return carList;
    }

    private int getTryCount() {
        String stringTryCount;

        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                stringTryCount = player.getInput();
                computer.isDigit(stringTryCount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
        }
        return Integer.parseInt(stringTryCount);
    }

}
