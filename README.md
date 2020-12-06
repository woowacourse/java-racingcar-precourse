# 미션 - 자동차 경주 게임
[1주차 프리코스, 피드백을 피드백하다](https://www.notion.so/1-8b5157674d1340d7a4086641f602d542)

[프리코스를 통해 공부한 것](https://www.notion.so/9186a1ce15b54fddb0c0ca0c8b99c39d)
## 🚀 기능 구현 목록
- 입력
    1. Scanner를 가지고 있는 추상 클래스(Input.java)
    2. 출전하는 선수들의 이름을 입력하는 클래스(InputName.java)
    3. 사용자가 반복횟수를 입력하는 클래스(InputRepetitions.java)
    
- 출력
    1. 각 횟수마다 실행 결과를 출력하는 메소드(Print.java)
    2. 최종 우승자를 출력하는 메소드(1명 이상 가능)(Print.java) 
    
- 게임 운영
    1. 게임 진행에 전부를 관리하는 클래스(GameManagement.java)
    2. 최종적인 승자를 찾아내어 관리하는 클래스(GameWinner.java)
    
- 예외 처리
    1. 이름의 길이가 5를 초과했을 때 예외를 발생시킨다.
    2. 플레이어의 수가 2 미만일 때, 게임을 진행할 수 없다고 판단, 예외를 발생시킨다.
    3. 반복 횟수를 입력 받을 때, 숫자가 아닌 것이 들어오면 예외를 발생시킨다.
    4. 단 모든 예외가 발생했을 때, 다시 입력할 수 있도록 만든다(예외 복구)

<br>

## methodtest package

### InputTest.java
    - 입력에 관한 테스트를 진행한 클래스
    
### GameRoutineTest.java
    - 게임이 돌아갈 때 필요한 메소드들을 테스한 클래스.

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

<br>
    
## racingcar package


### Application.java
    - 일단은 test로 진행중.
    
### Car.java
    - 입력받은 이름을 저장하고, position을 관리하는 클래스. 

### GameManagement.java
    - Car객체들을 선언하므로써 게임의 시작을 관리하는 클래스
    
### GameWinners.java 
    - 게임의 승자를 확인하는 클래스
    
<br>

## outpututils package


### Print.java
    - 게임의 모든 출력을 관리하는 클래스
    - 한 턴마다 게임의 결과 출력, 게임 종료 후 출력을 관리함.

<br>
    
## controlexception package


### UserInputNameLengthException.java
    - 사용자가 입력한 이름이 5를 넘어갔을 때 예외를 처리하기 위해만든 예외 클래스
    
### UserInputPlayerNumberException.java
    - 입력받은 플레이어들의 수가 2 미만일 때 게임을 진행할 수 없을 거라 판단하였다.
    - 이러한 예외를 처리하기 위해 만든 예외 클래스