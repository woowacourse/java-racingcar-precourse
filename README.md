## 구현 기능 목록
---
1. 시스템 메시지 목록 추가.
    - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    - 시도할 회수는 몇회인가요?
    - 실행 결과
    - 최종 우승자:
    - [ERROR]
2. 경주할 자동차 이름과 시도 횟수를 입력 받음.
3. 각 플레이어는 0 이상 9 이하의 난수를 획득함.
    - 난수가 4 이상이면 자동차를 전진함.
    - 난수가 4 미만이면 자동차를 멈춤. (이때, 자동차를 완전히 멈춘다는 것이 아니라 1턴만 일시적으로 멈춘다는 뜻임.)
4. "2."를 1턴할 때마다 진행 과정을 출력함.
5. 사용자가 입력한 시도 횟수만큼 턴을 반복하였다면, 최종 우승자를 출력함.
6. 예외 처리
    - 자동차 이름을 입력받을 때
        - 자동차의 이름은 5글자 이하이어야 함.
    - 시도할 횟수를 입력받을 때
        - 입력값은 1 이상의 자연수이어야 함.
        
    