# 자동차 경주 게임 _ 우아한 테크코스 2주차 미션

<https://github.com/okskna/java-racingcar>

------

## MainClass class

- main 메서드를 포함하는 클래스
- 자동차 경주 게임

#### 메인 메서드. public static void main(String[] args)

자동차 경주 게임의 시작부터 끝에 해당하는 메서드. 다음 기능을 순차적으로 실행한다.

- 사용자로부터 자동차의 이름을 입력받는다.
- 입력받은 이름으로 자동차를 객체화한다.
- 사용자로부터 경주 횟수를 입력받는다.
- 입력받은 경주 횟수만큼 자동차 경주를 실행한다. 
- 매 경주가 끝날 때 마다 경주 현황을 출력한다.
- 자동차 경주가 끝난 후 우승자를 고른다
- 우승자를 출력한다.

 

위 기능을 구현하기 위해 다음과 같은 메서드를 설계한다.

1. 메서드 1 _ static public String userInName() 실행
2. 메서드 2 _ static public Car[] makeCar(String[] names) 실행
3. 메서드 3 _ static public int userInMove() 실행
4. 메서드 4 _ static public void doRace(int moveIn) 실행
5. 메서드 5 _ static public void selectWinner() 실행



#### 메서드 1. static public String userInName()

 사용자로부터 자동차의 이름을 입력받아 배열(String[] names)에 저장하는 메서드이다. 이 배열은 자동차를 객체화 하는 메서드 2 에서 이용된다.

- @return: 입력받은 문자열 원본 그대로를 반환함



#### 메서드 2. static public Car[] makeCar(String[] names)

 메서드 1에서 얻은 문자열을 이용해 각각의 자동차 객체를 생성하는 메서드이다. 생성한 객체들은 Car[] cars에 저장된다.

- @param names: 사용자로부터 입력받은 이름들이 저장된 배열
- @return: Car 객체들이 저장된 배열



#### 메서드 3. static public int userInMove()

 사용자로부터 몇 번의 이동을 할 것인지에 대한 횟수를 입력받아 변수(int moveIn)에 저장하는 메서드이다. 이 변수는 자동차 경주를 하는 메서드 4 에서 이용된다.



#### 메서드 4. static public void doRace(int moveIn)

 메서드 3 에서 받은 moveIn 변수 만큼 자동차 경주를 진행하는 메서드이다. 이 과정에서 Car class의 goStop 메서드를 사용한다.

- moveIn 만큼 루프를 돈다. 매 루프마다 각 자동차를 Car class 의 goStop 메서드를 사용한다. 그 후 printRace(메서드 5)를 통해 경기 현황을 출력한다.
- @param moveIn: 사용자로부터 입력받은 경주 횟수가 저장된 변수
- **메서드 4-1. static public void printRace ()**
  -  cars에 담겨있는 객체들의 position 변수에 접근하여 경기 현황을 출력하는 메서드이다. Car class의 getPos메서드를 사용한다.



#### 메서드 5. static public void selectWinner()

 cars에 담겨있는 객체들의 position 변수에 접근하여 우승자를 찾는 메서드이다. Car class의 getPos메서드를 사용하여 우승자를 찾는다.

- **메서드 5-1. static public void printWinner()**
  -  메서드 6에서 구한 우승자를 콘솔창에 출력하는 메서드이다.







## Car class

- 자동차 클래스

#### 생성자 1. public Car(String name)

 name을 입력받아 Car class의 필드 중 name에 저장한다. position은 0으로 초기화되어 있다.



#### 메서드 1. public void goStop()

 Random class 를 이용하여 0~9 사이의 값을 얻은 후 그 값이 4 이상일 경우 position의 값에 1을 더하여 position에 저장한다.



#### 메서드 2. public int getPos()

 Car class 필드 중 private position 변수의 값을 알아내는 메서드이다.

- @return position: 자동차 클래스의 private position 변수



#### 메서드 3. public String getName()

 Car class 필드 중 private name 문자열의 값을 알아내는 메서드이다.

- @return name: 자동차 클래스의 private name 문자열