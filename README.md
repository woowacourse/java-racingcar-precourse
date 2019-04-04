# 우아한 테크코스 프리코스 미션 진행 저장소
우아한 테크코스 과정에 참여하기 위해 Delf(이상훈)가 3주간 주어진 미션을 열심히 수행하는 저장소입니다.
- 1주차 미션 - [PR](), [과정 및 느낀점](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-1.md)
- 2주차 미션 - [과정](https://github.com/Delf-Lee/study-archive/blob/master/woowacourse/tech-corce-mission-2.md)

# 2주차 미션 - 자동차 경주 게임

# 요구사항
## 기능 요구사항 
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이
하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구사항
### 객체 구현
다음 `Car` 객체를 활용해 구현해야 한다.
- `Car` 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 `private`을 변경할 수 없다. 
- 가능하면 `setPosition(int position)` 메서드를 추가하지 않고 구현한다.
``` java
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    // 추가 기능 구현
}
```
### 컨벤션
- 1주차 요구사항
    - 자바 코드 컨벤션을 지키면서 프로그래밍
    - indent depth는 2까지 허용
- 2주차 요구사항
    - 메서드 길이가 15라인을 넘어가지 않도록 구현한다.
    - `else` 예약어를 쓰지 않는다.
    
## 초기 구현 기능 목록
- 난수 발생기 구현
  - 확률 조정 가능하도록 구현(요구사항에서는 0.6의 확률로 전진, 0.4의 확률로 정지)
- 경주 기능 구현
  - `Car`객체 구현 및 세부화
- 출력 기능 구현
  - 요구사항은 콘솔창
- 테스트 구현
- 예외 처리
- 코드 리팩토링

## 최종 구현 기능 목록
- `자동차 전진 결정자`(이하 `CarAdvanceDecider`) 클래스 작성
- 경주 기능 구현
  - `Car` 클래스 구현
    - 이름과 현재 위치, 그리고 `CarAdvanceDecider`의 구현체를 가진다.
    - `CarAdvanceDecider`에 따라 전진과 정지를 결정하여 위치를 이동하는 메서드를 구현.
    - 현재 위치를 출력해주는 `toString`메서드를 오버라이딩.
  - `Track` 클래스 구현
    - 트랙 위의 모든 자동차들이 1회 전진할 기회가 주어지는 `next`메서드 구현
    - 자동으로 경기가 끝날때 까지 `next`메서드를 반복 실행하는 `excuteRaceUntilEnd`메서드 구현
    - 승자 결과를 반환하는 `getWinners`메서드 구현
    - 현재 트랙의 상태를 출력하기 위한 `toString`메서드를 오버라이딩.
  - 경주를 진행할 `RaceSimulator` 클래스 구현
- 입출력 기능 구현
  - 레이싱 게임에 필요한 변수 입력을 받는 인터페이스 `RaceIOInterface` 구현
  - 위의 인터페이스를 구현하여 콘솔에서 조작 가능한 클래스 `ConsoleIOInterface` 작성
- 예외처리
  - 사용자 입력에 대한 예외처리(이름과 시도 횟수에 대한 제한)
- 코드 리펙토링
  - 주석 추가
  - 예외 입력 처리 루틴 변경
  - `CarAdvanceDecider` 매개 변수를 직관적으로