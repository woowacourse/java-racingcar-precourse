# KueNiYam/java-racingcar-precourse

## Introduction
자동차 경주 게임 미션을 위한 저장소
> forked from woowacourse/java-racingcar-precourse

## Requirements
 - 주어진 횟수 동안 n 대의 자동차는 전진 또는 멈출 수 있다.
 - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
 - 사용자는 몇 번을 이동할 것인지를 입력할 수 있어야 한다.
 - 전진하는 조건은 0 에서 9 사이에서 랜덤 값을 구한 후 랜덤 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
 - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
 
 ## List of functions
 1. 이름을 쉼표로 구분하여 경주할 자동차들을 입력받는 기능 v
 2. 경주를 시도할 횟수를 입력받는 기능 v
 3. 확률적으로 자동차가 전진시키거나 멈추게 하는 기능 v
 4. 자동차의 이름과 위치를 출력하는 기능 (예시: "carName:---") v
 5. 주어진 횟수동안 3, 4를 반복시키는 기능
 6. 5가 끝난 후 우승자를 출력하는 기능
 
 ## Programming requirements
 ### 객체
 - 다음 Car 객체를 활용해 구현해야 한다.
 - Car 기본 생성자를 추가할 수 없다.
 - name, position 변수의 접근 제어자인 private을 변경할 수 없다.
 - setPosition() 메소드를 추가하지 않고 구현한다.
 
```java
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
}
```

### 1주차와 동일
 - 3항 연산자를 쓰지 않는다.
 - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while 문 안에 if 문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
    
### 2주차 변경 및 추가
 - 자바 코드 컨벤션을 지키면서 프로그래밍한다.
 - 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
 - else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - switch/case도 허용하지 않는다.
    
## Mission repository & Progress requirements
 - 미션은 https://github.com/woowacourse/java-racingcar-precourse 저장소를 fork/clone해 시작한다.
 - 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
 - git의 commit 단위는 "List of functions"에 정리한 기능 목록 단위로 추가한다.
 - 프리코스 과제 제출 문서 절차를 따라 미션을 제출한다.
 
 ## 2차 미션 마감 및 기준
  - 2019년 12월 10일(화) 23시 59분까지 GitHub을 통한 미션 제출과 메일전송까지 완료해야 한다.
  - 2019년 12월 11일(수) 00시 이후 추가 push도 허용하지 않는다.
  - 2019년 12월 11일(수) 00시 이후 제출한 경우 미션을 제출하지 않은 것으로 한다.