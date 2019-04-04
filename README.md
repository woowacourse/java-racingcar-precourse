# 2주차 미션 - 자동차 경주 게임

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차의 이름을 같이 출력한다.

* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

* 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우 전진하고, 3 이하의 값이면 멈춘다.

* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능 목록
1. 게임을 시작한다.

2. 자동차 이름 입력하라고 출력하고, 입력한다.

3. 쉼표를 기준으로 자동차 이름을 분리하여 자동차 리스트를 만든다.

4. 자동차 이름이 5자 이상인 것이 있다면 오류를 출력하고 다시 입력하도록 한다.

5. 시도할 횟수를 입력하라고 출력하고 입력한다.

6. 입력이 숫자가 아니라면 오류를 출력하고, 다시 입력하도록 한다.

7. random 숫자를 리턴한다.

8. 자동차가 앞으로 전진한다.

9. 모든 자동차에 random값을 부여하며, 해당 값이 4이상이면 전진하도록 한다.

10. 모든 자동차의 position에 따른 주행 상태를 출력한다. 

11. 시도 횟수만큼 주행을 끝내고, 가장 position의 값이 높은 값을 winnerPosition에 저장한다.

12. 모든 자동차를 탐색하며 winnerPosition의 값과 동일한 자동차의 이름을 출력한다.

## 클래스에 따른 주요 메소드 설명
### Car.java
* String getName() : 자동차의 이름을 리턴한다.
* int getPosition() : 자동차의 position을 리턴한다.
* void forward() : position 값을 1증가시킨다.

### User.java
* Vector<Car> inputCarName() : 자동차들의 이름 문자열을 입력한다.
* Vector<Car> tokenize(String) : ","를 기준으로 문자열을 분리하며, 분리된 문자열을 Vector에 담아 리턴한다.
* String inputTryCount() : 시도 횟수를 입력받아 리턴한다.
  
### Manager.java
* void startGame() : 게임을 실행한다. 게임의 전체적인 과정을 확인 할 수 있는 곳이다.
* boolean firstQuestion() : 경주할 자동차들의 이름을 입력한다.
* boolean CarName() : 모든 자동차의 길이가 5이하 인지 체크한다.
* boolean secondQuery() : 시도 횟수를 입력받아, 문자열이 아닌 숫자인지를 체크한다.
* int getRandomNumber() : 0~9 사이의 랜덤한 숫자를 리턴한다.
* void playIthTurn() : 시도 횟수의 매 턴마다 모든 자동차에 랜덤 값을 부여하여 4이상이면 i번째 자동차를 전진시킨다.
* void printCurrentState() : 시도 횟수의 매 턴마다 자동차들의 경주 상태를 출력한다.
* int getMaxPostion() : 자동차들 중에 가장 높은 position의 값을 리턴한다.
* void printWinner(int) : 우승자들의 이름을 출력한다.
* void firstWinnerOrNot(boolean) : 우승자가 여러 명 있을 때 첫 번째 우승자인지 아닌지 체크한다.
