# About
우아한테크코스 프리코스 2주차 미션 - 자동차 경주 게임
자세한 정보는 [여기서](https://github.com/woowacourse) 확인하세요.

# Features
- **랜덤 넘버 생성**
  - 0 <= random number <= 9
- **자동차 클래스 구현**
  - 이름과 위치를 인스턴스 변수로
- **사용자 입력 받기**
  - 각 자동차 이름 입력 받기 
    - 각 자동차의 이름 길이 <= 5
    - 각 자동차 이름 간 구분은 쉼표
  - 이동 횟수 입력 받기 
- **결과 출력**
    - 루프마다 바뀐 결과 출력
    - 우승자 출력 
- **이동 계산**
  - 각 이동이 끝난 후 결과 출력
- **우승자 계산**

# Required Coding Convention
- Indent Depth <= 2
- 3항 연산자(Ternary Op.) 사용 금지
- 메소드의 역할은 한 가지로
- 인스턴스 변수의 수 <= 2
- 메소드 인자 수 <= 3
- 코드 한 줄에 점 하나(Law of Demeter)
- 메소드 길이 <= 15
- 'else' 키워드 사용 금지

# Additional Implements 
- **사용자 입력이 조건을 준수할 때까지 재입력 요청**

# TODO
- 코딩 컨벤션 준수
- private 접근 제어자를 가진 필드를 클래스 외부에서 어떻게 접근할 수 있을까?
    - Why 'getter/setter' is evil?
        - 외부에서 클래스 내부 상세 구현으로 접근, Encapsulation을 깨뜨림  
    - reflection이 과연 해답일까? 