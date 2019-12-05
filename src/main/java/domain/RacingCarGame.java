package domain;

public class RacingCarGame {
    private int attemptsNum;
    private Car[] cars;
    
    public void playOneGame() {
        
    }
    
    /**
     * 자동차 이름을 CUI로 여러개(쉼표를 구분 기준으로) 입력받아
     * String 배열로 리턴하는 메서드
     * 
     * @return 입력받은 자동차 이름들이 담긴 String 배열
     */
    private String[] getCarNamesInputWithCUI() {
        String[] ret = new String[0];
        
        return ret;
    }
    
    private boolean isCarNamesCorrect(String[] carNames) {
        boolean ret = false;
        
        return ret;
    }
    
    /**
     * 총 몇 번의 이동(randomMoveCarsByOnePosition)을 할것인지를
     * 사용자에게 입력받아
     * moveAttemptsNum 속성을 업데이트하는 메서드
     */
    private void getAttemptsNumInputWithCUI() {
        
    }
    
    private boolean isAttemptsNumCorrect(int attemptsNum) {
        boolean ret = false;
        
        return ret;
    }
    
    /**
     * 매개변수로 받는 자동차 이름들 각각에 대해 Car 객체를 생성함
     * 
     * @param carNames : 생성될 Car 객체들 각각의 이름(name)목록
     */
    private void createCarInstances(String [] carNames) {
        
    }
    
    /**
     * 게임에 참여하는 자동차들 모두에 대하여,
     * 한 번의 위치이동 시도를 수행하는 메서드.
     * 
     * 각 자동차들은 위치가 1 증가하거나, 위치가 변하지 않는다.
     */
    private void randomMoveCarsByOnePosition() {
        
    }
    
    /**
     * 게임에 참여하는 자동차들 모두에 대하여,
     * 자동차들의 현재 위치를 보여주는 CUI
     */
    private void printCarsPositions() {
        
    }
    
    private void printWinners() {
        
    }
    
    /**
     * 위치 값이 가장 큰(이동이 많이 일어난) 자동차들을 return하는 메서드.
     * 
     * @return 위치 값이 가장 큰 자동차들의 이름 목록
     */
    private String[] getCarNamesWithLargestPosition() {
        String[] ret = new String[0];
        
        return ret;
    }
}
