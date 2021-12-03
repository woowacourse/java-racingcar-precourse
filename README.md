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

### 6. InputCheck class 예외 처리 구현
**사용자의 입력을 확인하여 예외처리를 한다.**

- checkNamesInput() 함수 구현
  - 자동차의 이름 입력을 확인
  - 잘못된 입력은 예외 발생, 에러 메시지
- checkRoundNumberInput() 함수 구현
  - 이동 횟수 입력을 확인
  - 잘못된 입력은 예외 발생, 에러 메시지

### 7. RacingGame.playStart()

- InputCheck class의 함수를 사용해 입력 확인

### 8. Application 구현
 **최종적으로 Application 구현**

<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
