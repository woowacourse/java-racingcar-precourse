# 프리코스 2주차 자동차경주게임



### 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. •자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 



### 프로그래밍 요구사항

#### 1. 객체

- [x]  Car 객체를 활용해 구현.
- [x]  Car 기본 생성자를 추가할 수 없다.
- [x]  name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- [x]  가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.

#### 2. 프로그래밍

- [x]  3항 연산자를 쓰지 않는다.
- [x]  Indent depth는 3이 넘지 않도록 구현한다.



---



### 구현할 기능 목록

- [x]  자동차 이름 입력받기 (각 자동차의 이름은 `쉼표(,)` 를 기준으로 구분)
- [x]  시도할 회수 입력받기
- [x]  랜덤값 생성
- [x]  랜덤값에 따른 자동차 제어
- [x]  우승자 출력 (우승자는 한 명 이상일 수 있음)



### 새로 공부한 내용

---

#### BufferedReader

- 다량의 데이터를 입력받을 경우, Scanner보다 Buffer 메모리를 사용하는 것이 훨씬 빠름.

- Enter만 경계로 인식하며, 데이터는 String으로 고정됨 _`(Scanner의 경우 Space와 Enter를 모두 경계로 인식받음)`_
- BufferedReader를 통해 입력을 받을 때 readLine을 통해 한 줄씩 입력받게 되는데, 예외처리를 꼭 해주어야 함.
  - try , catch 구문을 사용하기도 하지만 대개 `throws IOException`을 사용.

#### BufferedWriter

- BufferedWriter의 경우 버퍼를 잡아 출력하기 때문에 `flush()` , `close()`를 호출해 후처리를 해야 함.
  - BufferedWriter의 write의 경우 System.out.println() 과 같은 개행기능이 없으므로 `\n` 으로 직접 개행해야 함.
  - **버퍼 close() 이후에는 System.out.print 가 되지 않음.**
    - OutputStreamWriter를 이용해 출력하기 때문에 스트림을 닫은 이후에는 System.out.print도 되지 않았다.
    - 버퍼 스트림은 모든 작업이 끝난 후에 마지막으로 close 하는 것이 맞을 것 같다.

> 출처 : [Java BufferedReader, BufferedWriter를 활용한 입출력](https://coding-factory.tistory.com/251)

#### ArrayList

- c나 c++와 달리 java는 jvm에서 직접 메모리를 관리하기 때문에 따로 동적할당의 개념은 존재하지 않는다.
- c++의 vector와 같이 동적인 배열을 만들기 위해서는 ArrayList 객체를 사용할 수 있다.
- `ArrayList<dataType>` 의 형식으로 다양한 형식의 배열을 만들 수 있다.
  - e.g. `ArrayList<Car> Cars = new ArrayList<Car>();`