package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 결합도가 높은 프로그램 : 개발자가 생성하고 관리해야되는 객체들이 많아지는 프로그램
		LgTV tv1 = new LgTV();
		tv1.turnOn();
		tv1.soundUp();
		tv1.soundDown();
		tv1.turnOff();
	}
}
