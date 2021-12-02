# 미션 - 자동차 경주 게임

---

## 구현할 기능 목록

### 경주할 자동차의 이름 입력

- 자동차의 이름들은 쉼표를 기준으로 구분한다.
- 각 이름은 5글자 이하만 가능하다.
- 잘못된 값을 입력할 경우 IllegalArgumentException 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### 시도할 횟수 입력

- 0 이상의 정수만 입력 가능하다.
- 잘못된 값을 입력할 경우 IllegalArgumentException 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### 게임 진행

- 사용자가 입력한 시도 횟수만큼 반복한다.
- 0에서 9사이의 무작위 값을 생성하여 4 이상일 경우 전진한다.
- 각 차수마다 실행 결과를 출력한다. 전진 횟수는 "-"를 이용하여 표시한다.

### 게임 결과 출력

- 최종 우승자를 출력한다.
- 최종 우승자가 한 명 이상인 경우 ", "를 기준으로 구분하여 출력한다.

---

## 클래스 설계

### Application

- public static void main(String[] args)
    * racing car 게임 실행

### RacingCarGame

- private List<Car> cars
- public RacingCarGame()
    * 생성자
    * cars 초기화
- public void play()
    * 게임 진행
- public List<Car> makeCarList(List<String> names)
    * 이름들 입력받아 자동차 객체 리스트 만들기

### UserInput

- private List<String> names
    * 경주할 자동차의 이름 목록

- public void inputNames()
    * 경주할 자동차의 이름 입력받기
- private String[] readNames()
    * 이름 입력 읽기
- private void setNames(String[] input)
    * names 저장
- public List<String> getNames()
    * names 반환

### Car

- private final String name
    * 자동차 이름
- private int position
    * 전진 횟수
- public Car(String name)
    * 생성자

### Validation

- public static void isValidNames(String[] input)
    * 자동차 경주게임을 위한 자동차 이름을 입력했는지 확인
- private static boolean isMoreThanZero(String[] input)
    * 1개 이상의 이름을 입력했는지 확인
- private static boolean isValidLength(String[] input)
    * 5글자 이하의 이름을 입력했는지 확인

### Constant

- public static final String PLEASE_INPUT_NAMES
    * 자동차 이름 입력 요청
- public static final String ERROR
    * 에러메시지 시작
- public static final String ERROR_NO_NAMES
    * 1개 미만의 이름을 입력하여 에러 발생
- public static final String ERROR_MORE_THAN_FIVE_CHARACTERS
    * 5글자를 초과하는 이름을 입력하여 에러 발생
