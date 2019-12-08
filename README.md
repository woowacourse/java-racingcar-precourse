# 우아한 테크코스 프리코스 2주차 미션 - 자동차 경주 게임 (191205 ~ 1211)

## 기능 요구사항
##### • 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
##### • 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
##### • 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
##### • 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
##### • 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상 일경우 전진하고, 3이하의 값이면 멈춘다.
##### • 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명이상일 수 있다.

## 프로그래밍 요구사항 - 객체 지향 프로그래밍
##### • 다음 Car 객체를 활용해 구현해야 한다.
##### • Car 기본 생성자를 추가할 수 없다.
##### • name, position 변수의 접근 제어자인 private 을 변경할 수 없다.
##### • 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
```
public class Car {
    private final String name;
    private int position = 0;
    public Car(String name) {
        this.name = name;
    }
    // 추가 기능 구현
}
```

## 프로그래밍 요구사항 - 추가사항
##### • 3항 연산자를 쓰지 않는다.
##### • indent(인덴트,들여쓰기) depth 를 3이 넘지않도록 구현한다. 2까지만 허용한다.
##### • 예를 들어, while 문 안에 if 문이 있으면 들여쓰기는 2이다.
##### • 힌트 : indent(인덴트,들여쓰기) depth 를 줄이는 좋은 방법은 함수(또는메소드)를 분리하면 된다.
##### • 자바 코드 컨벤션을 지키면서 프로그래밍한다.
###### - https://naver.github.io/hackday-conventions-java/
##### • 함수(또는메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
###### - 함수(또는메소드)가 한 가지 일만 잘하도록 구현한다.
##### • else 예약어를 쓰지 않는다.
###### - 힌트 : if 조건절에서 값을 return 하는 방식으로 구현하면 else 를 사용하지 않아도 된다.
###### - else 를 쓰지 말라고하니 switch/case 로 구현하는 경우가 있는데 switch/case 도 허용하지 않는다.

## 메소드 구현 목록 작성
### Class Car
```
void drive(int position)
String getName()
int getPosition()
void printDistance()
void print(String string)
```
##### drive(int position) 메소드
###### 차 객체의 position 을 하나 증가시켜주는 메소드
##### getName() 메소드
###### 차 객체의 name 을 반환하는 메소드
##### getPosition() 메소드
###### 차 객체의 position 의 값을 반환해주는 메소드
##### printDistance() 메소드
###### 차 객체의 position 이 얼만큼인지 시각적으로 print 해주는 메소드
##### print(String string) 메소드
###### System.out.print 로 출력해주는 메소드



### Class CarComparator implements Comparator<Car>
```
@override
int compare(Car car1, Car car2)
```
##### compare(Car car1, Car car2) 메소드
###### Comparator 클래스는 이 메소드를 필수적으로 override 하며, 이 메소드를 통해 position 이 가장 큰 값을 가지는 순대로 Car 객체를 정렬할 것이다.



### Class CarNameCheck
```
ArrayList<Car> splitCarName(String carName)
String nameLengthCheck(String name)
```
##### splitCarName(String carName) 메소드
###### 사용자에게 입력받은 차 이름들을 콤마(,)로 분리한 다음에 어레이리스트에 담아 반환해주는 메소드
##### nameLengthCheck 메소드
###### 차 객체의 이름이 5이하인지 확인해서 아니면 다시 입력하게 하는 메소드



### Class InputScanner
```
String getCarName()
int howManyPlay()
```
##### getCarName() 메소드
###### 사용자가 입력한 차 객체 이름 나열 문자열을 입력받아 반환해주는 메소드.
##### howManyPlay() 메소드
##### 사용자에게 얼만큼의 게임 세트를 진행할 건지 입력받아 반환해주는 메소드.



### Class OutputPrint
```
void insertName()
void howManyTry()
void executeResult()
void finalWinner(String name)
void moreThanFiveLength(String name)
void println(String string)
```
##### insertName 메소드
###### 경주할 자동차이름을 입력하라는 메시지 출력.
##### howManyTry 메소드
###### 얼마나 시도할거냐는 메시지 출력.
##### executeResult()
###### 실행 결과 메시지 출력.
##### finalWinner(String name)
###### name (이)가 최종우승하였습니다. 메시지 출력.
##### moreThanFiveLength(String name)
###### 차 객체 name 은 5글자가 넘습니다. 메시지 출력.
##### println(String string) 메소드
###### System.out.println 로 입력받은 String 을 출력.



### Class Main
```
boolean canDrive()
void play(ArrayList<Car> carList)
int howManyWin(ArrayList<Car> carList)
boolean isSamePosition(Car carA, Car carB)
String printLastWinners(ArrayList<Car> carList)
```
##### canDrive() 메소드
###### 랜덤 클래스를 불러와서 0~9 까지 숫자 중 4이상이 나오면 TRUE 를 반환하는 메소드
##### play(ArrayList<Car> CarList) 메소드
###### 각 차 객체들을 경주시키고 그 결과를 print 해주는 메소드
##### howManyWin(ArrayList<Car> CarList) 메소드
###### 공동 1등인 Car 객체가 몇 대인지 반환하는 메소드
##### isSamePosition(Car carA, Car carB) 메소드
###### 두 차 객체의 position 이 같은 값이면 TRUE 를 반환하는 메소드
##### printLastWinners(ArrayList<Car> carList)
##### carList 에서 한 명이상의 이름 목록을 출력하는 메소드