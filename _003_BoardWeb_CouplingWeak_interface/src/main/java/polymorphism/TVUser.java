package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		TV tv = new LgTV(); // ��ü�� �������ָ��.
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}