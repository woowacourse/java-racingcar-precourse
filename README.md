# 🚘 자동차 경주 게임

### ⛳️ 주제 : 경주에 참가한 자동차들 중에 우승자 가려내기

## 💻 프로그래밍 실행 결과 예시

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



## 기능 목록

- #### 프로그래밍 구조 설계 ✅

- #### 사용자에게 자동차 입력 받기✅

  - 입력 받는 화면 출력 ✅

  - 자동차 입력 받기 ✅ 

  - 자동차 입력에 대한 예외처리 ✅

  > 예외 처리
  >
  > 자동차 이름은 공백을 포함하여 5자리를 넘기는 경우,
  >
  > ","로 구분된 자동차 이름이 빈 문자열인 경우
  >
  > 예외 입력시 에러메세지와 함께 입력화면 재실행

- #### 사용자에게 시도할 횟수 입력 받기

  - 입력 받는 화면 출력 ✅

  - 횟수 입력 받기 ✅

  - 횟수 입력에 대한 예외처리✅

    > 예외 처리
    >
    > 실행 횟수는 0보다 큰 정수
    >
    > 예외 입력시 에러메세지와 함께 입력화면 재실행

  

- #### 입력받은 횟수 만큼 경주 실행

  - ###### 자동차 전진 / 정지 판단

  - ###### 자동차 전진 혹은 정지하기

  - ###### 결과 반영

  - ###### 결과 출력

  - ###### 횟수 만큼 진행 시, 종료

  

- #### 우승자 선정

  - ###### 결과 반영 후 우승자 선정

  - ###### 우승자 출력

  

## 주요 요구사항

1. **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항**을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 **기능 목록**을 만들고, **기능 단위로 커밋** 하는 방식으로 진행한다.
2. **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
   - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
3. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
   - https://naver.github.io/hackday-conventions-java
4. JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
5. 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다.
6. 터미널에서 `java -version`을 실행해 자바 8인지 확인한다.
7. 터미널에서 `./gradlew clean test` 명령을 실행했을 때 모든 테스트가 통과하는지 확인한다.
8. 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
   - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
   - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
   - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

> *코드리뷰 후 추가내용*
>
> - 클래스 분리 하기
> - 매직넘버 사용하지 않기
> - 의미없는 주석 달지 않기
> - 기능 목록 검토하기

## 구현 요구사항

### Car 객체

- 다음 Car 객체를 활용해 구현해야 한다.
- Car 기본 생성자를 추가할 수 없다.
- name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

````java
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
````

### Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**