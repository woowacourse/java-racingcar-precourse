# 소프트웨어 요구사항
## 자동차 경주 게임
v0.1 by
안운장
(우아한테크코스 2기 프리코스)
2019.12.04.

## 목차
  * [작성내역](#작성내역)
  * [사용방법](#사용방법)
    * 1.1 [프로그램 개발환경](#11-프로그램-개발환경)
    * 1.2 [프로그램 실행방법](#12-프로그램-실행방법)
  * [기능적 요구사항](#기능적-요구사항)
    * 2.1 [주어진 요구사항](#21-주어진-요구사항)
    * 2.2 [실제 구현할 내용](#22-실제-구현할-내용)
  * [비기능적 요구사항](#비기능적-요구사항)
    * 3.1 [프로그래밍 요구사항](#31-프로그래밍-요구사항)

## 작성내역
| 작성자 | 작성일시 | 변경사유 | 버전 |
| ------ | -------- | ---------| -----|
| 안운장 | 2019.12.04 | 요구사항 정리 | 0.1 |

## 사용방법
### 1.1 프로그램 개발환경

- 운영체제: macOS 10.15.1
- 개발환경: OpenJDK Runtime Environment Corretto-11.0.3.7.1 (build 11.0.3+7-LTS)
- 에디터: IntelliJ IDEA 2019.2.4 Ultimate

### 1.2 프로그램 실행방법

- _추가예정_

## 기능적 요구사항

### 2.1 주어진 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 다음 `Car` 객체를 활용해 구현해야 한다.
  - `Car` 기본 생성자를 추가할 수 없다.
  - `name`, `position` 변수의 접근 제어자인 `private`을 변경할 수 없다. 가능하면 `setPosition(int position)` 메소드를 추가하지 않고 구현한다.
  
  ```java
  public class Car {
      private final String name;
      private int position = 0;
      public Car(String name) {
          this.name = name;
      }
  }
    // 추가 기능 구현
  ```

### 2.2 실제 구현할 내용
- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n" 출력 및 사용자 입력 받기
  - **예외처리**   
    - [ ] 입력이 없는 경우
    - [ ] 길이 6자 이상의 이름을 입력한 경우
    - [ ] 입력된 자동차 이름 중 하나 이상이 공백인 경우
    - [ ] 한/영 바이트가 다르므로 입력은 영어 대소문자에 한정 (regex로 필터링)
    
- [x] "시도할 회수는 몇회인가요?\n" 출력 및 사용자 입력 받기
  - **예외처리**
    - [ ] 입력이 없는 경우
    - [ ] 자연수가 아닌 경우
    - [ ] 수의 크기가 연산 범위를 넘어서는 경우
    
- [x] 실행 결과 연산 및 출력
  - [x] 매 턴 자동차마다 0에서 9 사이의 random 값을 구해 4 이상인 경우 전진, 3 이하인 경우 정지
  - [x] "실행결과\n" 출력
  - [x] 입력된 "시도할 회수"만큼 "경주할 자동차 이름"별로 이동거리 출력을 반복
    - [ ] 자동차 이름과 이동거리만큼의 "-" 출력
    - [x] 횟수별 출력 하단에 공백 줄 출력
    
- [x] 우승 자동차 이름 출력
  - [x] 단독 우승인 경우
  - [x] 공동 우승인 경우 이름 사이에 ", " 를 넣어 출력
  - **예외처리**
    - [ ] 모두가 0인 경우 (우승자가 없는 경우) 

## 비기능적 요구사항

### 3.1 프로그래밍 요구사항
- [ ] [Java 코드 컨벤션](https://naver.github.io/hackday-conventions-java/)을 지키면서 프로그래밍한다.
- [ ] indent depth를 1까지만 허용한다. 정말 힘든 경우 2까지 허용한다.
- [ ] 함수/메소드의 길이가 10라인을 넘어가지 않도록 구현한다.
- [ ] 함수/메소드의 인자 수를 3개까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] `else` 예약어를 쓰지 않는다.
- [ ] `public`/`protected`/`private`/`package` 접근 제어자를 용도에 적합하게 사용해 구현한다.
- [ ] 기능을 구현하기 전에 `README.md` 파일에 구현할 기능 목록을 정리해 추가 한다.
- [ ] Git의 commit 단위는 앞 단계에서 `README.md` 파일에 정리한 기능 목록 단위로 추가한다.

