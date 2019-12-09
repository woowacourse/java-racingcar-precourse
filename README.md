# RacingCar

## 동작 과정

### 입력
사용자로부터 자동차 목록, 라운드 수를 입력받는다.

### 진행
1. 각 Car에 대해 전진 시도를 한다.<br>
    1. 0~9 사이의 무작위 정수를 구한다.<br>
    2. 4이상이라면 전진한다.
2. 각 Car의 위치를 출력한다.
3. 지정된 라운드 수만큼 1~2를 반복한다.
4. 우승자를 출력한다.


## 클래스 구조

### Car
##### 멤버 변수
	private String name;
	private int position;

##### 멤버 함수
	public String getName();
	public int getPosition();

	public void drive();

### Race <code>extends AbstractRace</code>
##### 멤버 변수
    User user;

##### 멤버 함수
	public Race(User user);

	protected void getRandomInteger(int min, int max);

	protected void tryDrives();
	protected void tryDrive(Car car);
	protected void printStatus();

	protected ArrayList<Car> getWinners();
	protected void printResult();

	public void start();

### User <code>extends AbstractUser</code>
##### 멤버 변수
	protected ArrayList<Car> cars;
	protected int round;
##### 멤버 함수
	public ArrayList<Car> getCars();
	public int getRound()();

	protected String getLine();

	protected void inputCars();
	protected void inputRound();

	public void input();

### Main
1. User 객체를 만들어 사용자로부터 입력받는다
2. Race 객체를 만든다. 이때 생성자를 통해 User 객체를 매개변수로 넘겨준다.
3. Race의 start 메소드를 실행하여 레이스를 진행한다.
