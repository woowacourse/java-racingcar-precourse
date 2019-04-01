# 2주차 미션 - 자동차 경주 게임

## **기능 요구사항**
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자이하만 가능하다.
- 전지하는 조건은 0에서 9사이에서 random 값을 구한 후 random 갑이 4이상일경우 전진, 3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 구성
- Main.java
	- public static void main(String[] args)
- Car.java
	- private int getRandomNumber()
	- private void moveCheak(int num)
	- private void statusOutput()
	- public void race()
	- public int getPosition()
	- public String getName()
- GamePlay.java
	- private void getData()
	- private void splitString()
	- private void setCars()
	- public void start()
	- private void oneTimeRace()
	- private boolean nameLengthCheak()
	- private void findWinner()
	- private void winnerOutput(int[] winner, int winnersNumber)
	- private int getMaxIndex()

## Class & Method 설명

| Main.java | 프로그램을 실행시키기 위한 Class  |
| ----------- | ------------ |
| public static void main(String[] args) |   PlayGame class 를 생성해 게임을 실행시킨다.|

| Car.java | Car의 상태와 이동 변화를 제어한다.  |
| ----------- | ------------ |
| private int getRandomNumber()  | 0~9사이의 임의의 자연수를 얻는다.  |
| private void moveCheak(int num) | 입력받은 수로 Car의 이동과 진행을 판단한다.  |
| private void statusOutput()  | Car의 name과 position 을 출력한다.   |
| public void race() | 1회 레이스를 진행한다.  |
| public int getPosition() | 객체의 name 변수를 반환한다.  |
| public String getName() | 객체의 position 변수를 반환한다.   |


|  GamePlay.java | 게임을 규칙에 따라 진행하는 클레스  |
| ----------- | ------------ |
| private void getData() | 경주할 자동차와 횟수를 입력받는다.  |
| private void splitString()  | 자동차의 이름을 분리한다.  |
| private void setCars()  | Car객체를 자동차의 수에 맞개 생성하고 세팅한다.  |
| public void start()  | 게임을 횟수에 맞게 진행한다.  |
| private void oneTimeRace()  | 레이스를 1회 진행한다.  |
| private boolean nameLengthCheak()  |  자동차의 이름이 5자를 초과하는지 건사한다. |
| private void findWinner()  | 경기의 승자를 찾는다. 승자의 인덱스를 배열에 저장한다.|
| private int getMaxIndex()  | 가장 멀리간 자동차의 index를 찾아 반환한다. |
| private void winnerOutput(int[] winner, int winnersNumber) | 승자의 이름을 출력한다. |


## 프로그래머
권경동 (fancyartisan@gmail.com / rudehd10@naver.com)

## 체인지로그
