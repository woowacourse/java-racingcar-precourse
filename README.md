기능 구현 목록
==========


## racingcar 패키지 구성
```
Application.java

gamesource
 - Car.java
 - RacingGame.java

utils
 - NamesInputCheck.java
 - RoundNumberInputCheck.java
 
constants
 - ConstMessage.java
 - ConstValue.java
```
<br>

---
## 구현된 기능

### 1. 게임 실행

### 2. 자동차 이름 입력 받기
  - 5자 초과 시 예외 처리
  - 동일 이름 입력 시 예외 처리

### 3. 실행 횟수 입력 받기
  - 0이상의 정수가 아닐 경우 예외 처리

### 4. 1회 진행시 마다 자동차들의 위치 출력
  
### 5. 진행 완료시 우승자 출력
  - 출력 후 게임 종료

<br>

---
## 기능 구현 순서

### 1. InputCheck class 구현
**입력을 처리하는 클래스**

- List<string> parseNames()
  - 입력받은 문자열을 parsing하여 문자열로 반환한다.
  
### 2. RacingGame class 구현

**한 번의 게임을 관리, 실행하는 클래스**

- gameInit()
  - 객체의 초기 필드를 세팅
- 입력받은 만큼 Car 객체를 생성
  - 생성한 Car 객체를 필드값으로 저장
- playStart() 구현
  - 게임을 실행하는 함수


### 3. Car class 세부 함수 구현
**게임 플레이를 위한 세부 함수를 만든다.**

- getPosition(), getName() 함수 구현
  - 각 필드 값의 접근자 함수

- drive() 함수 구현
  - 위치 값을 랜덤으로 한 칸 전진 시키는 함수

- string toString() 오버로딩
  - 이름과 함께 위치를 반환

### 4. RacingGame class 세부 함수 구현
**구현한 Car class의 함수를 사용해 플레이를 세부 구현한다.**

- playNextRound() 함수 구현
  - 필드로 가진 모든 Car 객체들의 drive()를 실행
- printAllPosition() 함수 구현
  - 필드로 가진 모든 Car 객체들을 toString()으로 출력
- getMaxPosition()
  - 필드의 Car객체 중 가장 위치가 높은 값을 반환
- List<Car> getWinners()
  - 위치를 비교해 우승자들의 Car객체를 반환
- printWinners() 함수 구현
  - 단독 혹은 공동 우승자를 출력
- playStart() 재구성
  - 구현된 함수들로 게임 실행 구현
  - 모든 횟수 종료 후 우승자 출력

### 5. 상수 클래스 구현
**코드에 필요한 메시지,값들을 상수화하여 저장한다.**

- ConstMessage static final class 구현
- ConstValue static final class 구현
- 코드의 값들을 상수 값으로 변경

### 6. NamesInputCheck class 구현
**이름 입력을 확인과 예외처리를 한다.**

- void checkNamesLength(List<String> names)
  - parsing된 이름의 길이를 확인
  - 특정 길이(5) 초과시 IllegalArgumentException 예외 발생 

- boolean checkIsPossibleNames(List<String> names)
  - checkNamesLength()을 호출해 예외 처리
  - 이름의 길이가 모두 5이하일 때만 true 반환
  
- List<String> getRightNamesInput()
  - 입력 확인을 통해 올바른 경우에만 이름 List 반환
  
- checkRoundNumberInput() 함수 구현
  - 이동 횟수 입력을 확인
  - 잘못된 입력은 예외 발생, 에러 메시지

### 7. RoundNumberInputCheck class 구현

- int getRightRoundNumberInput()
  - 입력 확인을 통해 올바른 숫자인 경우에만 반환

- void StringToInt(String input)
  - Integer.parseInt()로 변환
  - NumberFormatException 예외 발생시 처리 후 IllegalArgumentException 발생 시킴

- boolean checkIsPossibleNumber(String input)
  - 입력이 숫자로 정상적으로 변환 되면 true 반환
  - 정상 변환이 안된다면 예외 처리

### 8. RacingGame.playStart()

- InputCheck class의 함수를 사용해 입력 확인

### 9. Application 구현
 **최종적으로 Application 구현**

---

## 추가 기능 구현

### 동일 이름 입력 확인
**같은 이름이 입력되면 구분할 수 없기 때문에 예외 처리 한다.**

- NamesInputCheck.checkHaveSameNames() 구현
  - 동일 이름은 예외를 발생 시키고  예외 메시지를 구분하여 출력


<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
