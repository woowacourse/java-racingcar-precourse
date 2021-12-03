# 미션 - 자동차 경주 게임

---

## 구현할 기능 목록

### 경주할 자동차의 이름 입력

- 자동차의 이름들은 쉼표를 기준으로 구분한다. ✅
- 각 이름은 5글자 이하만 가능하다. ✅
- 공백을 포함하거나 공백만을 가지는 이름은 허용하지 않는다. ✅
- 잘못된 값을 입력할 경우 IllegalArgumentException 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. ✅

### 시도할 횟수 입력

- 0 이상의 정수만 입력 가능하다. ✅
- 잘못된 값을 입력할 경우 IllegalArgumentException 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. ✅

### 게임 진행

- 사용자가 입력한 시도 횟수만큼 반복한다. ✅
- 0에서 9사이의 무작위 값을 생성하여 4 이상일 경우 전진한다. ✅
- 각 차수마다 실행 결과를 출력한다. 전진 횟수는 "-"를 이용하여 표시한다. ✅

### 게임 결과 출력

- 최종 우승자를 출력한다. ✅
- 최종 우승자가 한 명 이상인 경우 ", "를 기준으로 구분하여 출력한다. ✅

---

## 클래스 명세

### **Controller**

#### MainController

- final RacingCarGame racingCarGame
- InputController inputController
- GameController gameController


- public void start()
    * 시작
- private void setInput()
    * 사용자 입력 기능 수행하도록 InputController 에게 요청
    * racingCarGame 에 저장
- private void setCars()
    * cars 생성 및 저장
- private void play()
    * 시도 횟수만큼 게임 진행
- private void printResult()
    * 결과 출력

#### InputController

- final Input input = new Input()


- public Input setAndGetInput()
    * Input 생성하여 반환
- private void getName()
    * 자동차 경주를 위한 이름 입력
    * 정상적이지 않은 입력의 경우 에러메시지를 출력하고 입력 재요청
- private void getAttempt()
    * 자동차 경주를 위한 시도 횟수 입력
    * 정상적이지 않은 입력의 경우 에러메시지를 출력하고 입력 재요청

#### GameController

- public void play(List\<Car\> cars)
    * 게임 진행
    * 결과 출력
- private void moveOrNot(Car car)
    * 전진 가능한 경우에만 전진 진행
- private boolean decideMoveOrNot()
    * 랜덤 값 생성하여 전진 여부 반환

### **Service**

#### NameValidationService

- public static void isValidNames(String[] input)
    * 정상적인 이름 입력인지 확인
- private static boolean isMoreThanZero(String[] input)
    * 1개 이상의 이름을 입력하였는지 확인
- private static boolean doesSpaceExist(String[] input)
    * 공백을 포함하는 이름인지 확인
- private static boolean isValidLength(String[] input)
    * 각 이름이 5글자 이하인지 확인

#### AttemptValidationService

- public static void isValidAttempt(String input)
    * 정상적인 시도 횟수 입력인지 확인
- private static boolean isInteger(String input)
    * 정수를 입력하였는지 확인
- private static boolean isAttemptMoreThanZero(String input)
    * 1 이상의 숫자를 입력하였는지 확인

### **Model**

#### Input

- private String[] names
    * 자동차 이름
- private int attempt
    * 시도횟수


- public void setNames
    * names 저장
- public void setAttempt
    * attempt 저장
- public String[] getNames()
    * names 반환
- public int getAttempt()
    * attempt 반환

#### **Car**

- private final String name
    * 자동차 이름
- private int position = 0;
    * 전진 횟수


- public Car(String name)
    * 생성자
- public String getName()
    * 이름 반환
- public void move()
    * 전진
- public String printPosition()
    * 현재 전진 횟수를 출력 형식에 맞춰 반환
- public int compareTo(Car c)
    * Car 정렬을 위한 비교함수

#### RacingCarGame

- private Input input;
- private List\<Car\> cars


- public void setInput(Input input)
    * input 저장
- public void setCars(Input input)
    * input을 이용하여 cars 생성 및 저장
- public Input getInput()
    * input 반환
- public List<Car> getCars()
    * cars 반환

### **View**

#### InputView

- inputName()
    * 자동차 경주를 위한 이름 입력
- inputAttempt()
    * 자동차 경주를 위한 시도 횟수 입력

#### OutputView

- public static void printExecutionResult(List<Car> cars)
    * 각 차수별 실행결과 출력
- public static void printFinalWinner(List<Car> cars)
    * 최종 우승자 출력
