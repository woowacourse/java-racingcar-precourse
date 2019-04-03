# 1. 자동차 경주 게임

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고,
 3 이하의 값이면 멈춘다.

* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

#

# 2. 클래스
<pre>
    1. RacingCarGame
    2. Car
    3. Controller
</pre>

# 3. 기능 구현

## 3.1 RacingCarGame
    * 전체적인 게임 플로우를 갖고 있는 클래스

## 3.2 Car
    * 자동차와 관련된 모든 기능을 갖고 있는 클래스
<pre>
    1. goForward
    2. getPosition
    3. getCarsName
</pre>

## 3.3 Controller
    * 게임이 진행되는데 전체적인 조정 기능 갖고 있는 클래스
<pre>
    1. askCarsName
    2. askNumberOfAttempts
    3. checkNamesCriterion
    4. startGame
    5. checkCarsPosition
    6. checkWinner
    7. getLaps
    8. printCarRoad
</pre>

