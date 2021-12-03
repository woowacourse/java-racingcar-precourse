## 미션 - 자동차 경주 게임

---

####  [ 🏎 자동차 경주 게임 문제 링크](https://github.com/woowacourse/java-racingcar-precourse/blob/main/README.md)

####  🚗 게임 설명
N대의 자동차가 규칙에 의해 정지하거나 전진하며 가장 멀리간 자동차가 우승하는 게임

#### 📄 구현 기능 목록
1. 경주에 참여하는 자동차의 이름을 입력 기능
   - 자동차 이름은 쉼표(,)로 구분
   - 각 자동차의 이름은 **5자 이하**만 가능
   - **중복**되지 않은 값 입력
   - **공백** 입력 시 예외 처리 
2. 시도 횟수 입력 기능
   - 예외 사항
   - **숫자가 아닌 값** 입력 시 예외 처리
   - **1보다 작은 값** 입력 시 예외 처리
   - **공백** 입력 시 예외 처리 
3. 자동자 경주 게임 기능
   - 입력받은 시도 횟수만큼 진행
   - 전진 조건 : 0~9사이 무작위 값을 구한 뒤 4 이상일 경우 전진
   - 각 회차별 진행 상황 출력
   - 우승자 출력 : 1명 이상의 우승자 존재 가능
     - 1명일 경우 
       - ```최종 우승자 : pobi```
     - 여러명일 경우 쉼표(,)를 통해 구분 
       - ```최종 우승자 : pobi, jun```
        

