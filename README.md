# 미션 - 자동차 경주 게임

## 기능 목록 및 구조

- 이번 미션에서 새로이 적용할 개념 : Enum, 일급컬렉션, MVC, interface

- Architecture : MVC Pattern

1. Model
   1. Car
      - [ ] 차의 이름을 가져오는 기능 
      - [ ] 차의 위치를 가져오는 기능 
      - [ ] 차의 위치를 증가시키는 기능 
      - [ ] 차가 우승자인지 확인하는 기능
   2. CarList(일급 컬렉션)
      - [ ] 차들을 조건에 따라 움직이거나 정지하는 기능 
      - [ ] 가장 멀리간 차의 위치를 가져오는 기능 
      - [ ] 현재 차들의 각각의 위치를 가져오는 기능
   3. Number
      - [ ] 현재 숫자가 특정 숫자 초과인지 확인하는 기능
   4. NumberList(일급 컬렉션)
      - [ ] 현재 숫자들 중 특정 숫자 초과인 숫자들의 인덱스를 가져오는 기능

2. View
   1. InputView(interface)
      1. NameInputView
         - [ ] 사용자의 차량 이름 입력을 가져오는 기능
      2. TurnInputView
         - [ ] 사용자의 전체 게임 횟수 입력을 가져오는 기능
   2. OutputView
      - [ ] 사용자의 차량 이름 입력을 요구하는 기능 
      - [ ] 사용자의 전체 게임 횟수 입력을 요구하는 기능 
      - [ ] 게임이 한 차례 끝난 후 결과를 출력하는 기능 
      - [ ] 게임이 모두 끝난 후 최종 우승자를 출력하는 기능

3. Controller
   1. GameController
      - [ ] 사용자의 입력을 통해 게임을 진행하는 기능

- ETC

1. Utils
   - [X] 사용자의 입력을 특정 구분자를 기준으로 잘라주는 기능
   - [X] 특정 문자열이 임의의 조건을 만족하는지 알려주는 기능
   - [X] 특정 문자열이 특정 길이조건을 만족하는지 알려주는 기능
   - [X] 특정 문자열의 중복이 있는지 알려주는 기능
   - [X] 특정 문자열이 특정 길이 이상이며 특정 숫자 이상인지 알려주는 기능
   - [X] 문자열의 리스트가 비어있는지 알려주는 기능
   
2. Enums
   1. NumberEnum : 문제에서 쓰이는 int형 상수의 집합(ex. 차량 이동 조건인 4)
      - [ ] 상수의 값을 가져오는 기능
   2. CharEnum : 입력의 조건 검사에 쓰이는 char형 상수의 집합(ex. 현재 문자가 영어인지 확인하는 'a', 'z' 등)
      - [ ] 상수의 값을 가져오는 기능 
   3. StringEnum : 문제에서 쓰이는 String형 상수의 집합(ex. 구분자로 쓰이는 ",")
      - [ ] 상수의 값을 가져오는 기능
   
## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
