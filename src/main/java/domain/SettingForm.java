package domain;
/**
 * 게임 설정 단계를 포함하는 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public class SettingForm {

	private CarNameReceiver carNameReceiver;
	private TrialNumReceiver trialNumReceiver;
	private String[] carNames = null;
	private String[] gameSetting = null;
	private int trialNum = 0;

	/**
	 * CarNameReceiver, TrialNumReceiver 클래스 초기화 생성자
	 */
	public SettingForm() {
		carNameReceiver = new CarNameReceiver();
		trialNumReceiver = new TrialNumReceiver();
	}

	/**
	 * gameSetting 정보를 반환하는 메소드
	 * 입력받은 setting을 읽어오고 합친다.
	 * 
	 * @return gameSetting 정보
	 */
	public String[] getGameSetting() {
		readGameSetting();
		gameSetting = mergeSettings();

		return gameSetting;
	}

	/**
	 * 입력받은 차 이름, 진행 횟수를 가져오는 메소드
	 */
	private void readGameSetting() {
		carNames = carNameReceiver.readCarNames();
		trialNum = trialNumReceiver.readTrialNum();
	}

	/**
	 * 차 이름과 진행횟수를 하나의 배열로 합치는 메소드
	 * 
	 * @return gameSetting 정보
	 */
	private String[] mergeSettings() {
		gameSetting = new String[carNames.length + 1];
		for (int i = 0; i < carNames.length; i++) {
			gameSetting[i] = carNames[i];
		}
		gameSetting[gameSetting.length - 1] = Integer.toString(trialNum);

		return gameSetting;
	}
}
