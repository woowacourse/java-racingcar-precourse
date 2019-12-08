## 전체 클래스

- CarSetting

  - 자동차 경주 전 셋팅 (이름, 횟수, 차)

- Car

  - 자동차 이름, 전진 회수, 전진 담당

- Naming

  - 자동차 경주할 이름 설정

- Count

  - 자동차 전진 회수 설정

- MotorRace

  - 자동차 경주 진행 ~ 종료 총괄

<br>

## Car 클래스 기능

#### 기본 요소

- 인스턴스변수 

  - private final name : 이름
    
  - private int position : 진행정도

- 생성자 : public Car(String name)

  - name 파라미터를 받아서 해당 인스턴스의 name 변수에 셋팅
  
#### 기능 - void goingForward ()

- 조건

  - 0 ~ 9 사이의 수를 random하게 구함
  
  - 구한 수가 4 이상이면 전진, 3 이하면 정지

- 전진시 position +1

#### 기능 - int getPosition()

- position 수를 알려주는 메서드

<br>

## Naming 클래스 기능

#### 기능 - static String[] inputNames()

- 출력 : 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)

  - 자동차이름 입력받기
  
- 쉼표(,)로 구분하여 String[] names 생성

- checkNames(names)로 검증

- 반환 : String[]로 검증된 이름

#### 기능 - static boolean checkNames(String[] names)

- 자동차 이름이 5글자 이상일 경우 

  - 출력 : 자동차 이름은 최대 5글자까지 가능하며, 쉼표(,)로 구분됩니다. 다시 입력해주세요.

  - true 반환
  
<br>

## Count 클래스 기능

#### 기능 - static int inputCount()

- 출력 : 시도할 회수는 몇회인가요?

  - 회수 입력받기
  
- String count로 회수 대입

- checkCount(count)로 검증

- 반환 : 검증된 값을 int로 변환한 값

#### 기능 - static boolean checkCount(String count)

- 출력 : 시도할 회수 확인 후 다시 입력해주시기 바랍니다.

  - 숫자가 아닌 경우
  
  - 0보다 작은 숫자인 경우
  
  - int 범위 이상의 숫자일 경우
  
  - 반환 : true
  
<br>

## CarSetting 클래스 기능

#### 인스턴스 변수

- private List\<Car> cars;

- private int count;

#### 메서드 carSet()

- cars

  - Naming.inputNames()로 이름들을 입력받음

  - 입력받은 이름들로 Car 인스턴스들 생성

- count

  - Count.inputCount()로 전진 회수를 입력받음

<br>

## MotorRace 클래스 기능

#### 메인 메서드

- List\<Car> cars = CarSetting.cars;

- int count = CarSetting.count;

- goingCars(cars, count)로 회수만큼 전진

- checkWinner(cars)로 우승자 발표

#### void goingCars(Car cars, int count)

- 입력받은 회수만큼 반복

- car 인스턴스의 goingForward()를 호출함

- 완료시 carsConditions() 호출

#### void carsConditions(Car cars)

- 출력 : 자동차 이름 : -(현재 전진한 숫자) * 반복 + 공백 한 줄

- 예)
  <br>sun : ----
  <br>sunny : --

#### void checkWinner(Car cars)

- 누가 우승했는지 알려주기

  - 중복 가능
  
  - 인스턴스들의 position을 비교해야 함
  
- 출력 예시

  - a가 최종 우승했습니다.
  
  - a, b가 최종 우승했습니다.