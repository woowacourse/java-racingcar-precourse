#자동차 경주 게임:
>User가 자동차들의 이름과 게임횟수를 제공하면 Car class로 instantiate 한후 경주게임을 진행한다.

##class들 설명:

#### Car.java: 
#### Car이라는 class/object의 variabless와 methods를 정의한 class이다.

|variable명|유형|설명|
|---|---|---|
|private final String name|instance variable| 자동차의 이름이다.|
|private int position|instance variable|자동차의 위치이다.|

|java 상수 이름|설명|
|---|---|
|private static final int NAME_MIN_LENGTH|자동차의 이름의 최소 길이|
|private static final int NAME_MAX_LENGTH|자동차 이름의 최고 길이|
|private static final boolean IS_SOEMTHING_WRONG|조건을 체크할 수 있는 boolean value|
|private static final int STOP_OR_GO|자동차가 전진할지 멈출지 정하는 기준|

|  순서 |  method명 |  설명 |
|---|---|---|
|1|  askCarNames() |  자동차들의 이름을 User에게 묻는다. |
|1-1| isNameLengthBetweenOneAndFive() | User가 제공한 자동차 이름의 길이가 1에서 5인지 확인한다.|
|1-2|  isDuplicate()  |   User가 제공한 이름의 중복이 있는지 확인한다.|
|1-3| count()| 자동차의 이름이 String[]로 주어졌을 때 이름의 갯수를 세는 method|
|1-4|isNameAllWhitespace()|자동차 이름이 Whitespace만으로 이루어져 있는지 확인하는 method|
|1-5|countWhitespaces()|이름에 Whitespace를 세는 method|
|2| askHowManyTurns| 경주를 몇번 진행할 것인가 묻는다.|
|2-1| checkUserInput()|User가 제공한 횟수가 조건에 맞는지 확인한다.|
|2-2|isNonNumberThere()|User가 제공한 대답에 숫자가 아닌 문자가 있는지 확인한다.|
|2-3|isItSmallerThanOne()|User가 제공한 횟수가 0보다 작은지 확인한다.|
|3|instantiateAndReturn()|User가 제공한 자동차들의 이름을 활용해 자동차를 instantiate 한다.|
|4|updateCarMovements()|자동차들의 움직임을 update한다.|
|4-1|generateDistance()|자동차가 움직인 거리를 계산한다.|
|5|printCarMovements()|자동차가 움직인 거리를 출력한다.|
|6|announceWinners()|승자를 추려내서 출력한다.|
|6-1|decideMaxPosition()|가장 멀리 간 거리를 결정한다.|
|6-2|decideWinners()|승자들을 추려내어 ArrayList<Car>에 담아 return한다.|
|6-3|printWinners()|승자들을 출력한다.|

#### CarGameLauncher.java: 
#### Car.java에서 정의한 method들과 attributes을 활용하여 게임을 직접 플레이하는 class이다.
#### 게임을 시간의 흐름대로 prepareGame(), playGame(), endGame() 순서로 플레이하는 class이다.

|순서|method명|설명|
|---|---|---|
|1|main()|게임을 실행하기 위해 main method()를 정의한다.|
|2|doGame()|게임을 실행핸다.|
|3|prepareGame()|User에게 자동차 이름을 제공받은 후 자동차들을 Car 생성자를 통해 instantiate한다.|
|4|playGame()|User에게 게임 횟수를 제공받은 후 자동차의 움직임을 출력한다.|
|5|endGame()|승리한 자동차를 골라낸후 출겨한후 User에게 게임을 지속할 것인지 묻는다.|

## 전체 기능 구현 순서:

1. 실제 racing game이 일어날 파일인 CarGameLauncher.java를 생성한다.
2. CarGameLauncher.java 안에 main method를 정의한다.
<br/>2-1. main method에서 작동할 doGame(), prepareGame(), playGame(), endGame()을 정의한다.
3. 자동차 이름을 묻는 getCarNames() method를 정의한다.
<br/>3-1. User가 조건에 맞는 input을 제시하는 것을 돕기 위해 isNameLengthBetweenOneAndFive(),isDuplicate(),isNameAllWhitespcae(), countWhitespaces(), count() method 추가.
4. 경주를 몇번 할 것인지 묻는 askHowManyTurns() method를 정의한다.
5. User의 input이 맞는지 확인하는 ckechUserInput(), isNonNumberThere(), isItSmallerThanOne() method를 정의한다.
6. Class car를 instantiate하는 insatntiateAndReturn() method정의.
7. 자동차를 움직이는 updateCarMovements() method를 정의한다.
<br/>7-1. 자동차들이 움직인 거리를 계산하는 generateDistance() method를 정의한다.
8. 결과를 출력하는 printCarMovements() method를 정의한다.
9. 승자를 알리는 announceWinners() method를 정의한다.
<br/>9-1. 가장 높은 점수를 확인하는 decideMaxPosition() method를 정의한다.
<br/>9-2. 승자들을 추려내는 decideWinners() method를 정의한다.
<br/>9-3. 승자들을 출력하는 printWinners() method를 정의한다.

##기능 요구 사항:
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. (updateCarMovements())
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. (printCarMovements())
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능한다. (isNameLengthBetweenOneAndFive())
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. (askHowManyTurns())
5. 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다. (generateDistance())
6. 자동차 경주 게임을 완료한 후에 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다. (announceWinners())

##프로그래밍 요구사항:
1. Woowacourse에 제공한 Car객체를 활용하여 구현한다.
2. Car 기본 생성자를 추가할 수 없다.
3. name,position 변수의 접근 제어자인 private를 변경 할 수 없다.
4. 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
5. 자바 코드 컨벤션을 지킨다.
6. indent depth는 2까지만 허용한다.
7. 메소드의 길이가 15라인을 넘어가지 않는다.
8. else 예약어를 쓰지 않는다.