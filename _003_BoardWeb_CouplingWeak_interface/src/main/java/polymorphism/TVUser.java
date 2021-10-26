package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		TV tv = new LgTV(); // 객체만 변경해주면됌.
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
