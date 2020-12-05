# **미션 - 자동차 경주 게임**

> 경주할 자동차(들)와 이동 횟수를 입력했을 때 자동차들이 임의의 횟수 만큼 전진하고 우승자(들)가 출력되는 게임이다.

## **🚀 구현할 기능 목록**

- [x]  참가자, 자동차(들) 이름 입력과 그 객체(Car) 생성하여 HashMap에 저장
    - [x]  자동차 이름은 쉼표(,)를 기준으로 구분
    - [x]  예외 처리: 중복된 이름을 검사
    - [x]  이름은 5자 이하만 입력 가능
        - [x]  입력 이름의 양 옆 공백 제거 후 다시 입력됨
        - [x]  예외 처리: 길이 5 초과의 이름 입력
        - [x]  예외 처리: 공백인 이름 입력(예: `,,,`, `a, ,c`)
        - [x]  예외 처리: 이름이 입력되고 쉼표 뒤에 아무것도 없을 경우(예: `a,b,c,`, `a,b,c,,,`)
- [x]  사용자가 자동차의 이동 횟수 입력
    - [x]  예외 처리: 입력 값이 정수가 아닐 경우
    - [x]  예외 처리: 입력 값이 1 이상의 자연수가 아닐 경우
- [x]  이동 횟수만큼 라운드가 진행되도록 하기
    - [x]  한 라운드가 진행되면 모든 자동차를 이동을 시도한다.
        - [x]  각 자동차는 랜덤하게 이동한다.
            - [x]  전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
        - [x]  이동 결과를 라운드에 등록한다.
- [x]  주어진 횟수 동안 n대의 자동차가 전진 또는 멈추는 과정 이동 횟수만큼 출력
    - [x]  자동차 이름을 같이 출력
- [x]  자동차 경주 게임을 완료한 후 우승자(들) 출력

## 구현할 객체 및 클래스 목록

> 역할, 책임, 협력 관점으로 객체를 바라보기

- **Application (main)**
    - 게임 관리자를 생성한다.
    - 게임 관리자에게 게임을 시작하도록 한다.
- **객체 및 클래스**
    - **GameManager | 게임 관리자**
        - 게임을 시작한다.
            - 참가자와 이동횟수(i)를 입력 받고 검사한다
            - 이동 시도를 i번 반복한다 (i번의 라운드 진행)
            - 전광판이 라운드에 따른 이동을 출력한다.
            - 시상자가 우승자를 출력한다.
        - 게임이 끝난다.
    - **ReceptionForCars | 자동차(참가자) 입력 및 검사자**
    - **ReceptionForRound | 라운드(이동 횟수) 입력 및 검사자**
    - **Round | 라운드, 회차**
        - 자동차(들)을 이동을 시도하게 한다.
        - 자동차의 이동 정보를 **라운드 정보**에 등록한다.
    - **Car | 자동차**
        - 이동을 시도한다.
        - 이동 기록을 라운드에 전달한다.
        - 우승자인지 아닌지 답한다.
    - **MovementArbiter | 이동 결정권자**
        - 자동차가 이동 결과를 요청하면 임의의 수에 따른 결과를 전달한다.
    - **Board | 전광판**
        - 누적 라운드 정보에 따른 자동차(들)의 이동 현황을 출력한다.
    - **AwardGiver | 시상자**
        - 우승자(들)를 출력한다.