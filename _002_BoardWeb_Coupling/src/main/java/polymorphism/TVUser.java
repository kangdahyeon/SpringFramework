package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// ���յ��� ���� ���α׷� : �����ڰ� �����ϰ� �����ؾߵǴ� ��ü���� �������� ���α׷�
		LgTV tv1 = new LgTV();
		tv1.turnOn();
		tv1.soundUp();
		tv1.soundDown();
		tv1.turnOff();
	}
}
