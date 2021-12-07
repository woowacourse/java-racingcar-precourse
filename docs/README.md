# 📚 프리코스 2주차 미션 : 자동차 경주 게임 🏎️

## 📖 Description

- 사용자에게 경주에 참여할 자동차 이름과 시도 횟수를 입력받아 진행되는 자동차 경주 게임 프로그램입니다.
- 각 자동차 전진은 입력받은 횟수만큼 시도되며 0~9 사이에서 무작위 값을 뽑아 4 이상일 경우에만 전진합니다.
- 전진을 가장 많이 한 자동차가 경주에서 승리합니다. 전진 횟수가 같다면 공동 우승입니다.

## ⚙️Environment

- JAVA 8 버전 환경에서 개발되었습니다.
- JAVA 8 이외의 버전에 대한 호환성은 보장하지 않습니다.

## 🚀 Feature List

- ### 클래스에 상수 선언
    - 출력 메시지들을 상수로 선언
    - 에러 메시지들을 상수로 선언

- ### 자동차 이름 입력 및 검사
    - 쉼표로 구분된 2개 이상의 자동차 이름이 입력되었는지 검사
    - 쉼표 혹은 공백만 입력되었는지 검사
    - 각 자동차 이름 맨 앞, 뒤에 공백이 존재하는지 검사
    - 각 자동차 이름이 1자 이상, 5자 이하인지 검사
    - 자동차 이름 중 중복이 있는지 검사
    - 위 검사 중 하나라도 통과하지 못하면 예외 발생 후 해당 예외 에러 메시지 출력

- ### 시도 횟수 입력 및 검사
    - 숫자만 입력되었는지 검사
    - 1 이상의 숫자인지 검사
    - 위 검사 중 하나라도 통과하지 못하면 예외 발생 후 해당 예외 에러 메시지 출력

- ### 경주 진행
    - 0~9 사이에서 무작위 수 생성
    - 무작위 수가 4 이상인지 확인 후 정지 혹은 전진
    - 각 시도별 전진 결과 출력

- ### 경주 종료 후
    - 우승자 혹은 공동 우승자 판단
    - 우승자 혹은 공동 우승자 출력

***

## 🎮 Play Examples

- ### 정상적인 플레이

|#1|#2|#3|
|:---:|:---:|:---:|
|<img src="https://user-images.githubusercontent.com/68963707/145011266-274f4f82-77cf-45a8-ae03-63b7a8f5de1c.png" width="350" height="auto">|<img src="https://user-images.githubusercontent.com/68963707/145012107-7d23621e-868c-4131-a9f1-e1a1c6991c77.png" width=350 height="auto">|<img src="https://user-images.githubusercontent.com/68963707/145013250-9d257c93-5f96-4136-a790-6960e396b290.png" width=350 height="auto">|

<br>

- ### 자동차 이름 예외 처리

|자동차 이름 2개 미만 예외|공백으로만 이루어진 이름 예외|비어있는 이름, 이름 길이 예외|
|:---:|:---:|:---:|
|<img src="https://user-images.githubusercontent.com/68963707/145014143-820255fe-a2cd-4946-995d-88ed89d61230.png" width=350 height="auto">|<img src="https://user-images.githubusercontent.com/68963707/145014727-9920e023-9f40-4cba-ab43-b36430b0f99b.png" width=350 height="auto">|<img src="https://user-images.githubusercontent.com/68963707/145016267-d78509f6-b824-4bee-94a7-7c793ff2a14c.png" width=350 height="auto">|

|이름 맨 앞, 뒤에 공백 예외|이름 중복 예외|
|:---:|:---:|
|<img src="https://user-images.githubusercontent.com/68963707/145016844-2e56761b-b2ca-4620-a4e0-3895904268cd.png" width=350 height="auto">|<img src="https://user-images.githubusercontent.com/68963707/145018470-6e9005d9-cbc1-4307-817f-1792e96a5c53.png" width=350 height="auto">|

<br>

- ### 시도 횟수 예외 처리

|숫자가 아닌 문자 포함 예외|0 입력 예외|
|:---:|:---:|
|<img src="https://user-images.githubusercontent.com/68963707/145020348-f292b411-d8dd-45b2-a7a6-57691267e15a.png" width=290 height="auto">|<img src="https://user-images.githubusercontent.com/68963707/145020497-56c21777-4244-4cb8-ae2d-28c1de9a0fb6.png" width=280 height="auto">|
