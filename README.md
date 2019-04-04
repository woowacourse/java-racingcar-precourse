# [Car Racing Game - by hiwooj]



## 1. Car Racing Game 개요

- 자동차 경주 게임은 사용자가 입력한 n개의 자동차들이 경주를 벌여, 최종 승자를 가리는 게임이다.

  

## 2. 요구 기능

- 사용자는 경주를 벌일 자동차 이름을 입력하고, 경주 횟수를 지정할 수 있다.

- 자동차 이름은 쉼표(,)를 기준으로 구분하며, 이름의 길이는 5자 이하만 가능하다.

- 주어진 횟수 동안 n대의 자동차는 전진하거나 멈추게 된다.

- 전진 조건은 0에서 9사이의 random값을 구해, random값이 4이상일 경우에만 전진하는 것이다. 

- 횟수별 경주 결과를 출력할 때 자동차 이름과 함께 출력한다.

- 총 경주가 끝나면 누가 우승했는지 알려준다. 우승자는 한 명 이상일 수 있다.

  

## 3-1. 함수 설명 - Main Class

#### 1) public static String[] saveCarName(String[] tempCarName, boolean[] check)

- 사용자가 경주할 자동차 이름을 입력하고, 이는 (,)를 기준으로 구분된다.

#### 2) public static String[] checkCarName()

- 입력된 자동차 이름이 요구기능을 충족하는지 확인하는 함수이다.
- 자동차 이름이 5자를 초과하거나 입력값이 없을 경우를 체크한다.
- 최종 검수된 자동차 이름을 저장한다.

#### 3) public static int countCleanName(boolean[] check)

- 입력된 자동차 이름 중 올바른 값의 개수를 센다.

#### 4) public static String[] saveCarName(String[] tempCarName, boolean[] check)

- 자동차 이름 중 올바른 값을 저장한다.

#### 5) public static void printResult(Car[] cars)

- 자동차 경주의 결과 중, 가장 많이 전진한 자동차의 위치를 파악한다.
- 자동차 경주의 승자를 알려준다.

#### 6) public static void main(String[] args)

- 사용자가 자동차 이름과 경주 횟수를 입력하여 게임을 실행한다.

- 경주가 끝나고 게임 결과를 보여준다.

  

## 3-2. 함수설명 - Car Class

#### 1) public Car(String name)

- 객체에 이름값을 저장하며 생성 

#### 2) public String getName()

- 객체 이름값 가져오기

#### 3) public int getPosition()

- 객체 위치값 가져오기

#### 4) public boolean goOrNot()

- 특정 자동차가 이번 경수 회차에서 전진할지 말지 결정되는 함수
- 랜덤값을 부여받아서 4이상일 경우 전진한다.

#### 5) public void calculatePosition()

- 자동차가 전진하는 경우, 자동차의 위치값을 하나씩 증가시킨다.

#### 6) public void gameResult()

- 자동차 경주의 결과를 시각적으로 보여준다.