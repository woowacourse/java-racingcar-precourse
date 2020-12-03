# 미션 - 자동차 경주 게임

## 💁‍♂️ 소개 
> 자동차의 이름을 입력받고, 입력한 횟수만큼 자동차 경주를 진행하여 자동차 경주 게임의 우승자를 찾는 게임 

## 🎯 구현할 기능 목록 

> 기능을 구현하면서 문서를 계속 업데이트한다.  

- [x] 자동차의 이름을 입력받는 기능 
    - [ ] 자동차 이름이 5글자 이상인 경우 예외를 발생시킨다 
    - [ ] 자동차 이름이 공백인 경우 예외를 발생시킨다 
    - [ ] 자동차의 이름이 중복되는 경우 예외를 발생시킨다 
- [ ] 몇 번 이동 할 것인지 입력하는 기능 
    - [ ] 1 미만의 숫자를 입력받을 경우 예외를 발생시킨다  
    - [ ] 문자를 입력받을 경우 예외를 발생시킨다 
- [ ] 자동차가 전진 or 정지하는 기능
- [ ] 자동차들의 현재 위치를 출력하는 기능 
- [ ] 각 자동차의 이름과 이동한 위치를 출력하는 기능   
- [ ] 가장 멀리 나아간 자동차의 위치를 찾는 기능 
- [ ] 우승자를 찾는 기능 
- [ ] 우승자를 출력하는 기능 

## ✍️ 입출력 요구사항
### ⌨️ 입력
- [ ] 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
- [ ] 시도할 회수

### 🖥 출력
- [ ] 각 차수별 실행 결과
- [ ] 단독 우승자 안내 문구
- [ ] 공동 우승자 안내 문구

### 🚨 예외   
- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.

## ✅ 프로그래밍 요구사항
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.
- [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 `[ERROR]` 로 시작해야 한다.

### 추가된 요구사항
- [ ] 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] else 예약어를 쓰지 않는다.

### 프로그래밍 요구사항 - Application
- [ ] Application 클래스를 활용해 구현해야 한다.
- [ ] Application의 패키지 구조와 구현은 변경하지 않는다.
- [ ] `final Scanner scanner = new Scanner(System.in);`는 변경하지 않는다.
- [ ] `// TODO 구현 진행` 이 후 부터 구현한다.

### 프로그래밍 요구사항 - RandomUtils
- [ ] RandomUtils 클래스를 활용해 랜덤 기능을 구현해야 한다.
- [ ] RandomUtils의 패키지 구조와 구현은 변경하지 않는다.

### 프로그래밍 요구사항 - Car 객체
- [ ] 다음 Car 객체를 활용해 구현해야 한다.
- [ ] Car 기본 생성자를 추가할 수 없다.
- [ ] name, position 변수의 접근 제어자인 private을 변경할 수 없다.
- [ ] 가능하면 setPosition(int position) 메소드를 추가하지 않고 구현한다.
