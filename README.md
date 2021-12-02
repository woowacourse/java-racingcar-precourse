기능 구현 목록
==========


## racingcar 패키지 구성
```
Application.java

gamesource
 - Car.java
 - RacingGame.java

utils
 - InputCheck.java
 
constants
 - ConstMessage.java
 - ConstValue.java
```
<br>

---
## 구현 순서

### 1. RacingGame class 구현

**한 번의 게임을 관리, 실행하는 클래스**

- 생성자에서 입력받은 만큼 Car 객체를 생성
  - 생성한 Car 객체를 필드값으로 저장
- gameStart() 구현
  - 게임을 실행하는 함수

### 2. Car class 세부 함수 구현
**게임 플레이를 위한 세부 함수를 만든다.**

- getPosition(), getName() 함수 구현
  - 각 필드 값의 접근자 함수

- drive() 함수 구현
  - 위치 값을 랜덤으로 한 칸 전진 시키는 함수

- string toString() 오버로딩
  - 이름과 함께 위치를 반환

### 3. RacingGame class 세부 함수 구현
**구현한 Car class의 함수를 사용해 플레이를 세부 구현한다.**

- playNextRound() 함수 구현
  - 필드로 가진 모든 Car 객체들의 drive()를 실행
- printAllPosition() 함수 구현
  - 필드로 가진 모든 Car 객체들을 toString()으로 출력
- String getWinners()
  - 위치를 비교해 우승자들을 문자열 형태로 반환 
- gameStart() 재구성
  - 구현된 함수들로 게임 실행 구현
  - 모든 횟수 종료 후 우승자 출력

### 4. 상수 클래스 구현
**코드에 필요한 메시지,값들을 상수화하여 저장한다.**

- ConstMessage static final class 구현
- ConstValue static final class 구현
- 코드의 값들을 상수 값으로 변경

### 5. InputCheck class 구현
**사용자의 입력을 확인하여 예외처리를 한다.**

- checkNamesInput() 함수 구현
  - 자동차의 이름 입력을 확인
  - 잘못된 입력은 예외 발생, 에러 메시지
- checkRoundNumberInput() 함수 구현
  - 이동 횟수 입력을 확인
  - 잘못된 입력은 예외 발생, 에러 메시지

### 6. RacingGame.gameStart()

- InputCheck class의 함수를 사용해 입력 확인

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
