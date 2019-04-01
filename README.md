# 2주차 미션 - 자동차 경주 게임

> 1주차 미션 (함수의 분리) 에 추가적으로 클래스를 분리하는 것이 목표 !

## 기능 요구사항
- **주어진 횟수** 동안 n대의 자동차는 전진(goForward) 혹은 멈춤(stop) 할 수 있다.
- **각 자동차에 이름**을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력(printCarName)한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 *이름은 5자 이하*만 가능하다. (getCarNamesInput)
- 사용자는 몇 번의 이동을 할 것인지 입력(getMoveCountInput)할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후(getRandomNumber) random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.(moveCarByRandomNumber)
- 자동차 경주 게임을 완료한 후 **누가 우승했는지**(getWinner)를 알려준다. 우승자는 **한 명 이상**일 수 있다.

## 프로그래밍 요구사항 - 객체
- ***Car 기본 생성자를 추가할 수 없다.***
- ***name, position 변수의 접근 제어자인 private 를 변경할 수 없다.***
- ***가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.***

## 프로그램 요구사항
- 1주차 (Java Code Convention / Indent Depth)
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현
- else 예약어를 쓰지 않는다.

## 구현할 메서드

### Main 클래스

프로그램의 Entry Point 가 있고, 프로그램의 전체적인 흐름이 들어있는 클래스

### CarGame 클래스

자동차 게임을 진행하는데 필요한 데이터와 메서드를 제공하는 클래스

#### Data
| id  | name | desc |
|:---:|:---|:---|
| 1 | ``cars`` | Car 객체를 원소로 하는 ArrayList |
| 2 | ``runs`` | 시도할 회수를 저장하는 int 형 변수 |

#### Methods
| id  | name | desc |
|:---|:---|:---|
| 1 | ``CarGame()`` | Default Constructor, cars 와 runs 를 초기화 |
| 2 | ``getRuns()`` | Getter Method, runs 반환 |
| 3 | ``getCarNames()`` | 사용자로부터 자동차 이름들을 입력 받는 메서드 |
| 3-1 | ``printMessageCarNames()`` | 3의 실행 이전에 사용자에게 메시지를 출력하는 메서드 |
| 3-2 | ``makeCarListFromArray()`` | Helper Method, primitive array 를 받아 ArrayList 반환 |
| 4 | ``getRunNumbers()`` | 사용자로부터 시도할 회수를 입력 받는 메서드 |
| 4-1 | ``printMessageRunNumbers()`` | 4의 실행 이전에 사용자에게 메시지를 출력하는 메서드 |
| 5 | ``printResultTitle()`` | "실행 결과" 를 출력하는 메서드 |
| 6 | ``printResultEachGame()`` | 시행 횟수 1당 게임 결과를 출력하는 메서드 |
| 7 | ``runEachGame()`` | 각 car 마다 car.moveByRandomNumber() 를 실행하는 메서드 |
| 8 | ``printResultTotal()`` | 최종 우승자와 메시지를 출력하는 메서드 |
| 8-1 | ``arrayToStringJoin()`` | 배열의 원소들 사이이 콤마를 넣어 String 으로 반환하는 메서드 |
| 8-2 | ``countElementNumber()`` | ArrayList<Car>의 Car 원소 중 position 의 수를 카운트하는 메서드 |
| 8-3 | ``getWinnerArray()`` | ArrayList<Car>의 Car 원소 중 최대값들을 문자열 배열에 담아 반환하는 메서드 |

### Car 클래스

자동차 한 대의 정보가 들어있는 클래스

#### Data
| id  | name | desc |
|:---:|:---|:---|
| 1 | ``name`` | 이름이 저장된 String |
| 2 | ``position`` | 위치를 나타내는 int |

#### Methods

| id  | name | desc |
|:---|:---|:---|
| 1 | ``Car(String name)`` | Constructor, name 초기화하는 생성자 |
| 2 | ``getName()`` | Getter Method, 인스턴스의 name 을 반환 |
| 3 | ``goForward()`` | 전진하는 메서드, 전진하면 position 에 1이 추가된다 |
| 4 | ``stop()`` | 멈추는 메서드, 멈춰있으면 아무것도 하지 않는다. |
| 5 | ``getPosition() `` | 포지션 반환하는 메서드, int를 반환하는 것이 아니라, 하이픈을 position 의 수만큼 문자열로 바꿔 반환한다. |
| 6 | ``getRandomNumber()`` | 0부터 9 사이의 숫자를 랜덤으로 생성하는 메서드 |
| 7 | ``moveByRandomNumber()`` | 랜덤한 수가 4 이상이면 전진, 3 이하면 멈춤을 실행하는 메서드 |
| 8 | ``compareTo()`` | implements Comparable, Collections.max 메서드를 사용하기 위해 필요한 메서드 |
