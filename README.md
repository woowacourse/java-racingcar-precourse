# 미션 - 자동차 경주 게임

## 📕 Summary
  Java 8 과 gradle 을 기반으로 한 프로젝트로, 주어진 레이싱 게임을 요구사항에 맞춰 구현한다.  
  지난 1주차 과제에서 부족했던 점을 채우고, 추가된 요구 사항에 맞춰 설계와 코딩을 진행한다.

## 🔅 적용해 볼 사항
1. 실수 없는 TDD
2. 예외까지 분석한 설계 및 테스트
3. 일급 컬랙션
4. SOLID 에 근거한 클래스 분리
5. 정적 팩토리 메서드 적용


## 📁 Directory structure

## 🚀 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- [ ] 사용자로부터 경주할 자동차 이름들을 입력받는다.
- [x] 입력한 이름에 맞게 자동차들을 생성한다.
- [x] 생성한 자동차들을 저장한다.
- [ ] 사용자로부터 게임을 진행할 라운드수를 입력받는다.
- [ ] 횟수 만큼 자동차를 전진 혹은 정지시킨다.
- [ ] 매 라운드마다 자동차의 전진 정도를 출력한다.
- [ ] 사용자가 입력한 횟수만큼 라운드를 진행하고 게임을 종료한다.
- [ ] 게임을 종료하고 가장 멀리간 자동차를 선별한다.
- [ ] 우승자를 출력한다.
- [ ] 예외 발생시 에러메시지 출력 후, 재 입력을 받는다.

## 🪓 예외 처리 사항

애플리케이션 구동 간 발생할 예외를 정리한다.

- [ ] 콤마 ','와 영문 외 다른 문자가 입력하는 경우
- [ ] 한 자동차의 이름 길이가 5 문자를 초과하는 경우
- [ ] 시도 횟수가 숫자 외 다른 문자를 입력하는 경우
- [ ] 입력한 이름의 중복되는 경우

## ❓ Quesion
- [ ] 자동차의 대수를 제한할 필요가 있을까?
- [ ] 시도 횟수 입력에 대해 횟수 제한을 할 필요가 있을까?
- [ ] 움직인 차가 없는 경우는 어떻게 처리할까?

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


## 📎 Reference


## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
