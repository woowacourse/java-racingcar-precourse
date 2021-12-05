# 미션 - 자동차 경주 게임
## 😀🤔😏 프로젝트 설명
여기에 상세한 내용 작성하기

프로젝트의 구조와 사용된 기술? 아니면 클래스 구조 특정 로직의 방식, 사용된 테스트 등을 기술하자.

***중요한건 최대한 처음 보는 사람이 이것만 보고 "아 다 이해된다!" 라고 할 수 있을 정도로 해보자.***

#### 😀GameData class 
- 여기서 게임에 필요한 질문메세지와 에러메세지를 정의하고 수정할 수 있다.

#### 😀InputChecker interface
- RaceGame에서 정의된 인터페이스로 사용자의 입력에 대한 옳고 그름을 확인할 때 사용될 인터페이스이다.
- **DefaultChecker class** 처럼 해당 인터페이스를 구현하면 입력값에 대한 검증하고 예외를 발생시킬 책임을 부여받는다.

#### 😀RaceGame class 
- 게임에서 다음의 기능들에 대한 책임을 진다.
    - 사용자의 입력을 받는 기능과 예외발생시 예외를 처리할방법에 대한 권한또한 가진다. 그러나 예외 발생에 대한 권한은 InputChecker에게 위임한다.
        - 차이름 입력받는 기능
        - 횟수 입력받는 기능
        - 위 상황들에서 발생한 예외처리 기능
    
#### 😀Car class
- 자동차의 이동에 대한 책임을 진다.
    - 무작위수를 사용하고 이 숫자가 이동조건에 부합하면 이동.
- 현재 차의 이동거리를 출력하는 기능.
- 준비위치로 이동하는 기능.
- 다른 자동차와의 이동을 비교 하는 기능   -> 느림, 빠름, 같음을 비교해야함.
    
## ❗issue list
#### ❗사용자의 입력을 누가 받게 해야하나 RaceGame? Application?
답은 RaceGame이다. 예외 처리를 하려면 Application에서 하는것보다 RaceGame에게 권한을 주는게 추후 예외를 다루는 방식을 수정할 때 더 적합하다고 생각하였다.

#### ❗RaceGame에게 Car의 position을 드러내는게 과연 올바른가?
가장 멀리간 자동차를 선발하는 과정은 누가 책임지는게 옳은가? 에서 출발한 의문이다.

정답은... 잘 모르겠다. 그러나 완전한 캡슐화? 캡슐화에 대한 집착?을 하자면 캡슐화하나는 만족할것 같으니 
우선 방향은 Car의 속성 및 상태를 RaceGame에게 드러내지 않게 구현하기로 결정하였다.
---

## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.

## ✉️ 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr) 에 접속하여 프리코스 과제를 제출한다.
  - 자세한 방법은 [링크](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 를 참고한다.
  - **Pull Request만 보내고, 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
- 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

<br>

## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

### 🖥 출력

- 각 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.

```
[ERROR] 시도 횟수는 숫자여야 한다.
```

### 💻 프로그래밍 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

<br>

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
   - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
   - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.

### 추가된 요구사항

- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
   - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
   - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
   - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 프로그래밍 요구사항 - Car 객체

- 다음 Car 객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

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

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

<br>

---

## 📈 과제 진행 요구사항

- 미션은 [java-racingcar-precourse](https://github.com/woowacourse/java-racingcar-precourse) 저장소를 Fork/Clone해 시작한다.
- **기능을 구현하기 전에 java-racingcar-precourse/docs/README.md 파일에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
   - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고한다.

<br>

---

## 💡 구현할 기능 목록

각 기능이 마무리 됨과 동시에 맨위에 설명을 달자.

### 🏁입력 관련
  - 차이름 입력받는 기능
    - 예외) 5자를 넘어가면 예외
    - 보류) 예외) 같은 이름이 존재하지 않는게 좋음 
  - 횟수 입력받는 기능
    - 예외) 숫자이외의 문자가 들어오면 예외
    - 예외) 음수, int범위를 넘어서는 수
  - 위 상황들에서 발생한 예외처리 기능

### 🏁자동차 관련
- 자동차 생성 기능.
- 자동차의 전진 기능 (실패하면 정지 성공하면 전진)
- 준비위치로 이동 기능.
- 다른자동차와의  비교 기능.

### 🏁게임진행 관련
  - 게임 시작 기능
  - 자동차 추가 하는 기능
  - 경기 진행 기능
      - 턴제 시스템
      - 경기진행상황 출력 기능
  - 우승자 출력기능
     - 예외) 별도의 로직없이 턴이 0인경우 모두가 우승자로 출력이 되어야함

### 🏁클래스의 역할
- class **Application**
    - ~~입력이 올바른지 체크한다.~~ -> readLine 담당 
    - RaceGame클래스를 사용하여 게임을시작한다.

-  class **게임담당**
    - 게임의 진행 관련을 담당.
    - 문자열을 사용하여 자동차를 생성한다.
    - 게임시작 
    - 상황출력
    - 턴시스템,  각 자동차가 이동한 거리 계산.
    - 우승자선발
    - class **검증담당** 
        - 글자길이 체크

- class **자동차담당**
    - 자동차의 기능을 담당
    - 전진시도
    - 스스로 얼마나 이동했는지 출력할 수 있어야함.
    - 공개인터페이스: 차량이름, 전진여부
    

---
## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
