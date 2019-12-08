# 프리코스 2주차 : 자동차 경주 게임

##1. 프로그램 개요

이 프로그램은 여러 대의 자동차로 경주을 진행하는 **자동차 경주 게임**이다.

자동차의 개수는 사용자의 입력에 따라 결정되며,

자동차의 전진/정지는 난수에 기반한 확률로 정해진다.

게임이 종료되면, 우승자에 대한 정보를 출력해준다.

## 2. 기능 요구사항

**메인 클래스 개발**

- 경주 클래스를 생성한다.
- 경주 클래스의 경주 시작 메서드를 호출한다.

**경주 클래스 개발**

- 이름 입력과 그 예외처리에 대한 메서드를 만든다.
- 경기 횟수에 대한 입력 메서드를 만든다.

- 이름의 목록과 경기 횟수를 저장한다.
- 자동차 리스트를 생성하여 이름을 넣어준다.
- 경기 횟수에 맞춰 경기를 진행한다.
- 시도 횟수에 따른 게임 루프(자동차 클래스의 update 호출)를 만든다.
- 최종 우승에 따른 출력 메서드를 만든다.

**자동차 클래스 개발**

- 자동차 객체를 만들고, 전진에 필요한 메서드를 만든다.
- 내부에 상수값으로 랜덤 범위(얼마 이상일 때 전진) 를 저장한다.
- 이름과 위치값을 저장하고, 위치값은 setter 없이 내부 private 메서드로 조작한다.

**예외처리**

- 입력 예외처리

## 3. 예외처리 세부사항 및 참고사항

**예외처리할 부분**

- 이름의 길이/입력제한
  - 이름은 최대 5글자까지 가능하다.
  - 이름은 최소 1개 이상 입력되어야 한다.
- 이름 입력 문자열의 포맷 문제
  - 문자열이 아닌 값이 들어올 경우는 예외처리된다.
- 시도 횟수의 입력 예외처리
  - 값이 0보다 작거나 같을 경우는 예외처리된다.
  - 정수가 아닌 값이 들어올 경우는 예외처리된다.

## 4. 클래스 구조

**Car Class**

- [Var] PASS_UNDER_BOUND : 자동차 가속 연산때 기준값이 되는 int형 static final 정수값이다.
- [Var] name : 이름을 저장하는 String형 final 객체이다.
- [Var] position : 현재 위치를 저장하는 int형 정수값이다.
- [Constructor] Car : 이름을 입력받아 저장한다. Car 객체의 생성자이다.
- [Method] accelerateCar : 자동차를 난수값을 바탕으로 가속시킨다. 변경된 위치를 반환한다.
- [Method] getName : String형 변수 name을 반환해준다.
- [Method] getPosition : int형 변수 position을 반환해준다.

**Race Class**

- [Var] MESSAGE_END_RACE : 레이스 종료시 출력되는 string형 상수값이다.
- [Var] MESSAGE_ASK_REPEAT : 횟수 입력시 출력되는 string형 상수값이다.
- [Var] MESSAGE_ASK_NAME : 이름 입력시 출력되는 string형 상수값이다.
- [Var] MESSAGE_INPUT_ERROR : 입력 도중 예외처리 발생시 출력되는 string형 상수값이다.
- [Var] MESSAGE_SPLIT_NAME : 이름을 분리할 때 분리자로 사용할 string형 상수값이다.
- [Var] MESSAGE_START_RACE : 레이스 시작시 출력되는 string형 상수값이다.
- [Var] carList : Car형 객체를 담고 있는 List 객체이다.
- [Var] raceRepeat : 경주 반복 횟수를 담고 있는 int형 변수이다.
- [Var] maxRaceRecode : 경주 최고 기록을 담고 있는 int형 변수이다.
- [Constructor] Race : 객체의 변수 객체들을 생성하고 입력값(이름, 횟수)을 받는다. Race 객체의 생성자이다.
- [Method] acceleateCarList : 리스트에 저장된 Car형 객체들을 가속(Car::accelerateCar() 호출)시킨다.
- [Method] makeRaceRecode : 가속 도중에 호출되어, 전진한 자동차의 위치가 최고 기록인지 확인, 기록을 갱신한다.
- [Method] getRaceWinnerToString : 경주가 종료된 뒤라고 가정하고, 승자의 정보를 담은 메세지를 생성한다.
- [Method] addNameToString : 문자열에 다른 문자열을 합쳐서 반환해준다.
- [Method] splitNameString : 처음에 입력되는 String형태의 입력을 쪼개 이름의 리스트로 만들어준다.
- [Method] getNameToInput : 이름 문자열을 입력받고, 예외처리를 진행한다.
- [Method] getRepeatToInput : 횟수 값을 입력받고, 예외처리를 진행한다.
- [Method] findExceptionOnName : 이름 입력 과정에서 생기는 예외처리 여부를 검사하여, Boolean 형태로 결과를 돌려준다.
- [Method] raceStart : 경주를 시작한다. 정해진 횟수만큼 가속을 반복하고, 결과를 출력한다. 상위 객체에서 호출된다.