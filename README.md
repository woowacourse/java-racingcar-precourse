# 미션 - 자동차 경주 게임
[1주차 프리코스, 피드백을 피드백하다](https://www.notion.so/1-8b5157674d1340d7a4086641f602d542)

[프리코스를 통해 공부한 것](https://www.notion.so/9186a1ce15b54fddb0c0ca0c8b99c39d)
## 🚀 기능 구현 목록
- 입력
    1. Scanner를 가지고 있는 추상 클래스(Input.java)
    2. 출전하는 선수들의 이름을 입력하는 클래스(InputName.java)
    3. 사용자가 반복횟수를 입력하는 클래스(InputRepetitions.java)
    
- 출력
    1. 각 횟수마다 실행 결과를 출력하는 메소드
    2. 최종 우승자를 출력하는 메소드(1명 이상 가능) 
- 게임 운영
    1. 게임 진행에 전부를 관리하는 클래스(GameCycle.java)
    
- 예외 처리
    1. 이름이 5자 이상일 때 발생하는 예외
    2. 숫자가 아닌 문자가 입력될 경우 발생하는 예외

<br>

## inpututils package

### Input.java
    - Scanner를 가지고 있는 추상 클래스이다.
    - Application에서 scanner를 매개변수로 가지고와서 사용한다.
    - Input package에 있는 모든 클래스들은 이 scanner를 사용한다.
    
### InputName.java
    - 사용자가 선수들의 이름을 입력할 때 사용하는 클래스이다.
    - ","를 통하여 구분한다.
    - 많은 예외사항이 존재할 것으로 예상된다.(", "이런식으로 나눈다던지? -> 이건 그냥 추가해주는 게 사용자 측면에서 좋을 듯?)
    
### InputRepetitions.java
    - 사용자가 반복횟수를 정하는 클래스이다.
    - 숫자만 입력받는다.(나머지는 예외로 처리 -> 진행중)
    - 제한은 없다.
    
## racingcar package

### Application.java
    - 일단은 test로 진행중.
    
### Car.java
    - 입력받은 이름을 저장하고, position을 관리하는 클래스. 

### GameCycle.java
    - 전체적인 게임 사이클을 관리하는 클래스