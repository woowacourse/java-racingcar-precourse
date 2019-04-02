###### 기능 구현
---
- 자동차 이름 입력받기  
  - ","로 문자열 분리
  - 각 이름이 5글자 넘어가는지 확인
    - 넘어가는 이름이 있으면 다시 입력
  - 이름 중복 제거
- 주어진 횟수(N)를 입력받기
- Car instance 생성
  - 입력받은 자동차 이름으로 각각의 instance 생성
  - ArrayList에 저장 후 반환
- Car class
  - access method
    - getPosition
    - getName
  - move
    - 0 ~ 9 임의의 정수 생성 
    - 4 이상인 경우 전진, 그렇지 않으면 정지
- N회 시행
  - 매 시행 마다 Car object에 대해 move 시행
  - 모든 Car object에 대해 자동차 이름과 progression bar 출력
- 우승자 출력
  - 이동 거리와 이름으로 정렬하여 우승자(혹은 공동 우승자) 출력