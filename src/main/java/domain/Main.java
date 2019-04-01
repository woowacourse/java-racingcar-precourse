package domain;
/**
 * 게임 프로그램을 시작하는 클래스
 *
 * @author wschoi8640
 * @version 1.1
 */
public class Main {

	private static SettingForm settingForm;
	private static GameForm gameForm;
	private static String[] gameSetting = null;
	
	/**
	 * 게임 전체를 시작하는 메소드
	 * 게임 정보를 받아 온 후 이를 이용해 게임 진행 클래스 진행
	 */
	public static void main(String[] args) {
		settingForm = new SettingForm();
		gameSetting = settingForm.getGameSetting();
		gameForm = new GameForm(gameSetting);
	}
}